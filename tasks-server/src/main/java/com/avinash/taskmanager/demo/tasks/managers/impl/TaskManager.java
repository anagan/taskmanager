/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.execptions.InvalidArgumentException;
import com.avinash.taskmanager.demo.tasks.managers.ITaskListManager;
import com.avinash.taskmanager.demo.tasks.managers.ITaskManager;
import com.avinash.taskmanager.demo.tasks.models.Task;
import com.avinash.taskmanager.demo.tasks.models.entity.TaskEntity;
import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;
import com.avinash.taskmanager.demo.tasks.repository.ITaskDao;
import com.avinash.taskmanager.demo.tasks.repository.ITaskListDao;
import com.avinash.taskmanager.demo.tasks.utilities.CommonUtil;

/**
 * @author Avinash
 *
 */
@Service
public class TaskManager implements ITaskManager {

	private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);

	@Autowired
	ITaskListManager taskListManager;

	@Autowired
	ITaskDao taskDao;

	@Autowired
	ITaskListDao taskListDao;

	@Autowired
	ModelMapper modelMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskManager#getAllTasks(java.
	 * lang.String)
	 */
	@Override
	public List<Task> getAllTasks(String listId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskManager#getTask(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public Task getTask(String listId, String taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskManager#createTask(java.lang
	 * .String, com.avinash.taskmanager.demo.tasks.models.Task)
	 */
	@Override
	@Transactional
	public Task createTask(String listId, Task task) {
		logger.debug("Creating task for list: {}", listId);

		TaskListEntity taskListEntity = taskListManager.getTaskListEntity(listId);

		TaskEntity taskEntity = convertToEntity(task);

		if (null == taskEntity) {
			throw new InvalidArgumentException("Error saving task for list: " + taskListEntity.getListId());
		}

		taskEntity.setParId(taskListEntity);
		taskEntity.setCreatedTime(Timestamp.from(Instant.now()));
		taskListEntity.getTasks().add(taskEntity);
		taskListEntity.setModifiedTime(Timestamp.from(Instant.now()));
		taskListDao.save(taskListEntity);
		return convertFromEntity(taskEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskManager#updateTask(java.lang
	 * .String, java.lang.String, com.avinash.taskmanager.demo.tasks.models.Task)
	 */
	@Override
	public Task updateTask(String listId, String taskId, Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskManager#deleteTask(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<DeleteDocument> deleteTask(String listId, String taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Task convertFromEntity(TaskEntity taskEntity) {

		if (null == taskEntity) {
			return null;
		}
		Task task = modelMapper.map(taskEntity, Task.class);
		return task;
	}

	private TaskEntity convertToEntity(Task task) {

		if (null == task) {
			return null;
		}

		TaskEntity taskEntity = modelMapper.map(task, TaskEntity.class);
		taskEntity.setTaskId(StringUtils.isEmpty(task.getTaskId()) ? CommonUtil.UUID() : task.getTaskId());
		return taskEntity;
	}
}
