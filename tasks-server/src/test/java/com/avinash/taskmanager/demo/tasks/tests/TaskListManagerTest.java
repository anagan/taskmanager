/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.avinash.taskmanager.demo.tasks.execptions.NotFoundException;
import com.avinash.taskmanager.demo.tasks.managers.ITaskListManager;
import com.avinash.taskmanager.demo.tasks.managers.IUserManager;
import com.avinash.taskmanager.demo.tasks.managers.impl.TaskListManager;
import com.avinash.taskmanager.demo.tasks.models.TaskList;
import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;
import com.avinash.taskmanager.demo.tasks.models.entity.UserEntity;
import com.avinash.taskmanager.demo.tasks.repository.ITaskListDao;
import com.avinash.taskmanager.demo.tasks.repository.IUserDao;

/**
 * @author Avinash
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskListManagerTest extends ApplicationTests {

	private static final String USER_ID = "1122112211";
	private static final String LIST_ID = "1b996192-62b0-4244-a9ea-687068c14d6c";

	@TestConfiguration
	static class TaskListManagerTestContextConfiguration {

		@Bean
		public ITaskListManager taskListManager() {
			return new TaskListManager();
		}
	}

	@Mock
	IUserDao userDao;

	@Mock
	ITaskListDao taskListDao;

	@MockBean
	IUserManager userManager;

	@Autowired
	ITaskListManager taskListManager;

	@Before
	public void setUp() {

		UserEntity userEntity = new UserEntity();
		userEntity.setGivenName("John");
		userEntity.setFamilyName("Doe");
		userEntity.setActive(true);
		userEntity.setCreatedTime(Timestamp.from(Instant.now()));
		userEntity.setUserId(USER_ID);

		Mockito.when(userDao.findByUserId(userEntity.getUserId())).thenReturn(userEntity);

		TaskListEntity taskListEntity = new TaskListEntity();
		taskListEntity.setTitle("Test");
		taskListEntity.setParent("root");
		taskListEntity.setType("LIST");
		taskListEntity.setUser(userDao.findByUserId(userEntity.getUserId()));
		taskListEntity.setListId(LIST_ID);
		taskListEntity.setTrashed(false);

		Pageable pageRequest = new PageRequest(0, 1);

		Page<TaskListEntity> taskListEntityPage = new PageBuilder<TaskListEntity>()
				.content(Arrays.asList(taskListEntity)).pageRequest(pageRequest).totalElements(0).build();

		Mockito.when(userDao.save(userEntity)).thenReturn(userEntity);

		Mockito.when(userDao.findByUserId(USER_ID)).thenReturn(userEntity);

		Mockito.when(taskListDao.save(taskListEntity)).thenReturn(taskListEntity);

		Mockito.when(taskListDao.findByListIdAndTrashedFalse(LIST_ID)).thenReturn(taskListEntity);

		Mockito.when(taskListDao.findByUser_userIdAndTrashedFalse(USER_ID, pageRequest)).thenReturn(taskListEntityPage);

		Mockito.when(userManager.getLoggedInUser()).thenReturn(userEntity);
	}

	@Test
	public void whenCreateTaskList_thenReturnTaskListEntity() {

		final TaskList taskList = new TaskList();
		taskList.setListId(LIST_ID);

		assertThat(taskListManager.createTaskList(taskList).getListId().equals(LIST_ID));

	}

	@Test(expected = NotFoundException.class)
	public void whenGetTaskListByListId_thenReturnNotFoundException() {

		taskListManager.getTaskList(LIST_ID);
	}
}

class PageBuilder<T> {

	private List<T> content = new ArrayList<>();
	private Pageable pageRequest;
	private int totalElements;

	public PageBuilder() {
	}

	public PageBuilder<T> content(List<T> content) {
		this.content = content;
		return this;
	}

	public PageBuilder<T> pageRequest(Pageable pageRequest) {
		this.pageRequest = pageRequest;
		return this;
	}

	public PageBuilder<T> totalElements(int totalElements) {
		this.totalElements = totalElements;
		return this;
	}

	public Page<T> build() {
		return new PageImpl<T>(content, pageRequest, totalElements);
	}
}
