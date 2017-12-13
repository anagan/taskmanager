/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class TaskListDaoTest extends ApplicationTests {

	private static final String USER_ID = "1122112211";
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ITaskListDao taskListDao;
	
	@MockBean
	IUserDao userDao;
	
	@Before
	public void setUp() {
		UserEntity user = new UserEntity();
	    user.setGivenName("John");
	    user.setFamilyName("Doe");
	    user.setActive(true);
	    user.setCreatedTime(Timestamp.from(Instant.now()));
	    user.setUserId(USER_ID);
	    user.setId(1);
	 
	    Mockito.when(userDao.findByUserId(user.getUserId()))
	      .thenReturn(user);
	}
	
	@Test
	public void whenFindByUser_userIdAndTrashedFalse_thenReturnTaskListEntity() {
		
		UserEntity userEntity = userDao.findByUserId(USER_ID);
		
		TaskListEntity taskListEntity = new TaskListEntity();
		taskListEntity.setTitle("Test");
		taskListEntity.setParent("root");
		taskListEntity.setType("LIST");
		taskListEntity.setUser(userEntity);
		
		entityManager.merge(taskListEntity);
	    entityManager.flush();
	    
	    Page<TaskListEntity> pageTaskListEntity = taskListDao.findByUser_userIdAndTrashedFalse(userEntity.getUserId(), new PageRequest(0, 1));
	    assertThat(pageTaskListEntity.getContent().size()).isEqualTo(1);
		assertThat(pageTaskListEntity.getContent().get(0).getTitle()).isEqualTo("Test");
	}
	
	@Test
	public void whenisAuthorized_thenReturnTrue() {
		
		UserEntity userEntity = userDao.findByUserId(USER_ID);
		
		TaskListEntity taskListEntity = new TaskListEntity();
		taskListEntity.setTitle("Test");
		taskListEntity.setParent("root");
		taskListEntity.setType("LIST");
		taskListEntity.setUser(userEntity);
		
		TaskListEntity persistedEntity = entityManager.merge(taskListEntity);
	    entityManager.flush();
	    
	    boolean authorized = taskListDao.isAuthorized(persistedEntity.getId(), userEntity.getUserId());
	    assertThat(authorized).isEqualTo(true);
	}
	
	@Test
	public void whenNotAuthorized_thenReturnFalse() {
		
		UserEntity userEntity = userDao.findByUserId(USER_ID);
		
		TaskListEntity taskListEntity = new TaskListEntity();
		taskListEntity.setTitle("Test");
		taskListEntity.setParent("root");
		taskListEntity.setType("LIST");
		taskListEntity.setUser(userEntity);
		
		TaskListEntity persistedEntity = entityManager.merge(taskListEntity);
	    entityManager.flush();
	    
	    boolean authorizedInvalidId = taskListDao.isAuthorized(1000000L, userEntity.getUserId());
	    assertThat(authorizedInvalidId).isEqualTo(false);
	    
	    boolean authorizedInvalidUserId = taskListDao.isAuthorized(persistedEntity.getId(), "123456789");
	    assertThat(authorizedInvalidUserId).isEqualTo(false);
	}
	
	@Test
	public void whenFindByListIdAndTrashedFalse_thenReturnTaskListEntity() {
		
		String listId = "1b996192-62b0-4244-a9ea-687068c14d6c";
		
		UserEntity userEntity = userDao.findByUserId(USER_ID);
		
		TaskListEntity taskListEntity = new TaskListEntity();
		taskListEntity.setTitle("Test");
		taskListEntity.setParent("root");
		taskListEntity.setType("LIST");
		taskListEntity.setUser(userEntity);
		taskListEntity.setListId(listId);
		
		entityManager.merge(taskListEntity);
	    entityManager.flush();
	    
	    TaskListEntity taskListEntityResult = taskListDao.findByListIdAndTrashedFalse(taskListEntity.getListId());
		assertThat(taskListEntityResult.getListId()).isEqualTo(listId);
	}
}