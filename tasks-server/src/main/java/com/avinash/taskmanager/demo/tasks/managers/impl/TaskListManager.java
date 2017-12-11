/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.managers.ITaskListManager;
import com.avinash.taskmanager.demo.tasks.models.TaskList;

/**
 * @author Avinash
 *
 */
@Service
public class TaskListManager implements ITaskListManager {

	private static final Logger logger = LoggerFactory.getLogger(TaskListManager.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#getAllTaskLists(
	 * )
	 */
	@Override
	public List<TaskList> getAllTaskLists() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#createTaskList(
	 * com.avinash.taskmanager.demo.tasks.models.TaskList)
	 */
	@Override
	public TaskList createTaskList(TaskList taskList) {
		logger.info("Creating taskList");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskListManager#updateTaskList(
	 * java.lang.String, com.avinash.taskmanager.demo.tasks.models.TaskList)
	 */
	@Override
	public TaskList updateTaskList(String taskListId, TaskList taskList) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
