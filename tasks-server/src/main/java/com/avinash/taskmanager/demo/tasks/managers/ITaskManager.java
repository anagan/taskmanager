/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers;

import java.util.List;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.execptions.InActiveUserException;
import com.avinash.taskmanager.demo.tasks.execptions.InvalidArgumentException;
import com.avinash.taskmanager.demo.tasks.models.Task;

/**
 * 
 * @author Avinash
 *
 */
public interface ITaskManager {

	/**
	 * Fetches all tasks associated with a list. The list must be authorized for a
	 * logged-in user.
	 * 
	 * @param listId
	 * @return {@link List} of {@link Task}
	 * @throws NotFoundException
	 *             when user is not authenticated or list is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	List<Task> getAllTasks(String listId);

	/**
	 * Fetches a task associated with an existing list and identified by taskId. The
	 * list must be authorized for a logged-in user.
	 * 
	 * @param listId
	 * @param taskId
	 * @return {@link Task} * @throws NotFoundException when user is not
	 *         authenticated or list is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	Task getTask(String listId, String taskId);

	/**
	 * Creates a {@link Task} for an existing list. The list must be authorized for
	 * a logged-in user.
	 * 
	 * @param listId
	 * @param task
	 * @return created {@link Task}
	 * 
	 * @throws NotFoundException
	 *             when user is not authenticated or list is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 * @throws InvalidArgumentException
	 *             when error saving task
	 */
	Task createTask(String listId, Task task);

	/**
	 * Updates a {@link Task} for an existing list. The list must be authorized for
	 * a logged-in user.
	 * 
	 * @param listId
	 * @param taskId
	 * @param task
	 * @return updated {@link Task}
	 * @throws NotFoundException
	 *             when user is not authenticated or list is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	Task updateTask(String listId, String taskId, Task task);

	/**
	 * Deletes a {@link Task} for an existing list. The list must be authorized for
	 * a logged-in user.
	 * 
	 * @param listId
	 * @param taskId
	 * @return {@link DeleteDocument} containing deleted task id
	 * @throws NotFoundException
	 *             when user is not authenticated or list is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	List<DeleteDocument> deleteTask(String listId, String taskId);
}
