/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.managers.ITaskManager;
import com.avinash.taskmanager.demo.tasks.models.Task;

/**
 * @author Avinash
 *
 */
@Service
public class TaskManager implements ITaskManager {

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
	public Task getTask(String taskId, String listId) {
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
	public Task createTask(String taskId, Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.avinash.taskmanager.demo.tasks.managers.ITaskManager#updateTask(java.lang
	 * .String, java.lang.String, com.avinash.taskmanager.demo.tasks.models.Task)
	 */
	@Override
	public Task updateTask(String taskId, String listId, Task task) {
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
	public List<DeleteDocument> deleteTask(String taskId, String listId) {
		// TODO Auto-generated method stub
		return null;
	}

}
