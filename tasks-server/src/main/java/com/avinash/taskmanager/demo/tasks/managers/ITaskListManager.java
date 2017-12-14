/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.execptions.InActiveUserException;
import com.avinash.taskmanager.demo.tasks.models.TaskList;
import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;

/**
 * @author Avinash
 *
 */
public interface ITaskListManager {

	/**
	 * Fetches all list for an authenticated user
	 * 
	 * @param pageRequest
	 * @return a paginated list of {@link TaskList}
	 * @throws NotFoundException
	 *             when user is not authenticated or taskList is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	Page<TaskList> getAllTaskLists(Pageable pageRequest);

	/**
	 * Fetches a specified list for an authenticated user
	 * 
	 * @param taskListId
	 * @return {@link TaskList}
	 * @throws NotFoundException
	 *             when user is not authenticated or taskList is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	TaskList getTaskList(String taskListId);

	/**
	 * Creates a list for an authenticated user
	 * 
	 * @param taskList
	 *            must not be null
	 * @return created {@link TaskList}
	 * @throws NotFoundException
	 *             when user is not authenticated or taskList is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 * 
	 */
	TaskList createTaskList(TaskList taskList);

	/**
	 * Updates a specified list for an authenticated user
	 * 
	 * @param taskListId
	 * @param taskList
	 *            must not be null
	 * @return updated {@link TaskList}
	 * @throws NotFoundException
	 *             when user is not authenticated or taskList is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	TaskList updateTaskList(String taskListId, TaskList taskList);

	/**
	 * Deletes a specified list for an authenticated user
	 * 
	 * @param taskListId
	 * @return {@link List} of {@link DeleteDocument} containing deleted list &
	 *         tasks
	 * @throws NotFoundException
	 *             when user is not authenticated or taskList is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	List<DeleteDocument> deleteTaskList(String taskListId);

	/**
	 * Fetches a specified list for an authenticated user
	 * 
	 * @param taskListId
	 *            must not be null or empty
	 * @return {@link TaskListEntity}
	 * @throws NotFoundException
	 *             when user is not authenticated or taskList is not found
	 * @throws InActiveUserException
	 *             when user is marked disabled or inactive
	 */
	TaskListEntity getTaskListEntity(String taskListId);
}
