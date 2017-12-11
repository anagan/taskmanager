/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers;

import java.util.List;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.models.Task;

/**
 * @author Avinash
 *
 */
public interface ITaskManager {

	List<Task> getAllTasks(String listId);
	
	Task getTask(String taskId, String listId);
	
	Task createTask(String taskId, Task task);
	
	Task updateTask(String taskId, String listId, Task task);
	
	List<DeleteDocument> deleteTask(String taskId, String listId);
}
