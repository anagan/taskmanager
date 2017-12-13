/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.execptions.NotFoundException;
import com.avinash.taskmanager.demo.tasks.managers.ITaskListManager;
import com.avinash.taskmanager.demo.tasks.managers.IUserManager;
import com.avinash.taskmanager.demo.tasks.models.TaskList;
import com.avinash.taskmanager.demo.tasks.models.entity.TaskEntity;
import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;
import com.avinash.taskmanager.demo.tasks.models.entity.UserEntity;
import com.avinash.taskmanager.demo.tasks.repository.ITaskDao;
import com.avinash.taskmanager.demo.tasks.repository.ITaskListDao;
import com.avinash.taskmanager.demo.tasks.utilities.CommonUtil;

/**
 * @author Avinash
 *
 */
@Service
public class TaskListManager implements ITaskListManager {

	@Autowired
	ITaskListDao taskListDao;
	
	@Autowired
	ITaskDao taskDao;

	@Autowired
	IUserManager userManager;

	@Autowired
	ModelMapper modelMapper;

	private static final Logger logger = LoggerFactory.getLogger(TaskListManager.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#getAllTaskLists(
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<TaskList> getAllTaskLists(Pageable pageRequest) {
		logger.debug("Getting all taskLists for an authenticated user");

		UserEntity userEntity = userManager.getLoggedInUser();
		Page<TaskListEntity> taskListEntities = taskListDao.findByUser_userIdAndTrashedFalse(userEntity.getUserId(),
				pageRequest);
		return convertFromEntityListPage(taskListEntities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#getTaskList(java
	 * .lang.String)
	 */
	@Override
	public TaskList getTaskList(String taskListId) {
		logger.debug("Getting taskLists for an authenticated user by taskListId: {}", taskListId);
		return convertFromEntity(getTaskListEntity(taskListId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#createTaskList(
	 * com.avinash.taskmanager.demo.tasks.models.TaskList)
	 */
	@Override
	@Transactional
	public TaskList createTaskList(TaskList taskList) {

		logger.debug("Creating taskList");

		UserEntity userEntity = userManager.getLoggedInUser();
		TaskListEntity taskListEntity = convertToEntity(taskList);
		taskListEntity.setUser(userEntity);
		taskListEntity.setCreatedTime(Timestamp.from(Instant.now()));
		return convertFromEntity(taskListDao.save(taskListEntity));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#updateTaskList(
	 * java.lang.String, com.avinash.taskmanager.demo.tasks.models.TaskList)
	 */
	@Override
	@Transactional
	public TaskList updateTaskList(String taskListId, TaskList taskList) {
		logger.debug("Updating taskList for an authenticated user by taskListId: {}", taskListId);

		TaskListEntity taskListEntity = getTaskListEntity(taskListId);

		if (null != taskList.getParent() && !taskListEntity.getParent().equals(taskList.getParent())) {
			taskListEntity.setParent(taskList.getParent());
		}

		if (null != taskList.getColor() && !taskListEntity.getColor().equals(taskList.getColor())) {
			taskListEntity.setColor(taskList.getColor());
		}

		if (null != taskList.getTrashedTime() && !taskListEntity.getTrashedTime().equals(taskList.getTrashedTime())) {
			taskListEntity.setTrashedTime(taskList.getTrashedTime());
			taskListEntity.setTrashed(true);
		}

		if (null != taskList.getType() && !taskListEntity.getType().equals(taskList.getType())) {
			taskListEntity.setType(taskList.getType());
		}

		if (null != taskList.getParent() && !taskListEntity.getParent().equals(taskList.getParent())) {
			taskListEntity.setParent(taskList.getParent());
		}

		taskListEntity.setModifiedTime(Timestamp.from(Instant.now()));

		return convertFromEntity(taskListDao.save(taskListEntity));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#deleteTaskList(
	 * java.lang.String)
	 */
	@Override
	public List<DeleteDocument> deleteTaskList(String taskListId) {
		
		TaskListEntity taskListEntity = getTaskListEntity(taskListId);
		
		List<DeleteDocument> deletedDocs = new ArrayList<>();
		List<TaskEntity> taskEntities = taskListEntity.getTasks();
		
		if(CollectionUtils.isNotEmpty(taskEntities)) {
			for(TaskEntity taskEntity: taskEntities) {
				deletedDocs.add(new DeleteDocument(taskEntity.getTaskId(), taskEntity.getType()));
			}
		}
		
		taskListDao.delete(taskListEntity);
		deletedDocs.add(new DeleteDocument(taskListEntity.getListId(), taskListEntity.getType()));
		
		return deletedDocs;
	}

	@Override
	public TaskListEntity getTaskListEntity(String taskListId) {
		UserEntity userEntity = userManager.getLoggedInUser();
		TaskListEntity taskListEntity = taskListDao.findByListIdAndTrashedFalse(taskListId);

		if (null == taskListEntity) {
			throw new NotFoundException("Not found");
		}

		boolean authorized = taskListDao.isAuthorized(taskListEntity.getId(), userEntity.getUserId());

		if (!authorized) {
			throw new NotFoundException("Not found");
		}

		return taskListEntity;
	}

	private Page<TaskList> convertFromEntityListPage(Page<TaskListEntity> taskListEntities) {

		if (null == taskListEntities) {
			Collections.emptyList();
		}

		return taskListEntities.map(t -> convertFromEntity(t));
	}

	private TaskList convertFromEntity(TaskListEntity taskListEntity) {

		if (null == taskListEntity) {
			return null;
		}

		TaskList taskList = modelMapper.map(taskListEntity, TaskList.class);
		return taskList;
	}

	private TaskListEntity convertToEntity(TaskList taskList) {

		if (null == taskList) {
			return null;
		}

		TaskListEntity taskListEntity = modelMapper.map(taskList, TaskListEntity.class);
		taskListEntity.setListId(StringUtils.isEmpty(taskList.getListId()) ? CommonUtil.UUID() : taskList.getListId());
		return taskListEntity;
	}
}
