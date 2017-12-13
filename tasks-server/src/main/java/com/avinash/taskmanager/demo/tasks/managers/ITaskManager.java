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
	
	Task getTask(String listId, String taskId);
	
	Task createTask(String listId, Task task);
	
	Task updateTask(String listId, String taskId, Task task);
	
	List<DeleteDocument> deleteTask(String listId, String taskId);
}
