/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.taskmanager.demo.common.annotations.DeleteDocumentType;
import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.managers.ITaskListManager;
import com.avinash.taskmanager.demo.tasks.models.TaskList;
import com.avinash.taskmanager.demo.tasks.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

/**
 * Provides APIs for creating & managing lists
 * 
 * @author Avinash
 *
 */
@RestController
@RequestMapping("/api/v1/users/self/lists")
public class TaskListController {

	@Autowired
	private ITaskListManager taskListManager;

	/**
	 * API endpoint for fetching all lists for an authenticated user
	 * 
	 * @param pageRequest
	 * @return {@link List} of {@link TaskList}
	 */
	@ApiOperation(value = "Get all tasks lists", notes = "Gets all tasks lists for an authenticated user.", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	@JsonView(View.TasklistWithTaskSummary.class)
	public ResponseEntity<Page<TaskList>> getAllTaskLists(Pageable pageRequest) {
		return new ResponseEntity<>(taskListManager.getAllTaskLists(pageRequest), HttpStatus.OK);
	}

	/**
	 * API endpoint for fetching a list for an authenticated user
	 * 
	 * @param listId
	 * @return {@link TaskList}
	 */
	@ApiOperation(value = "Get a specific task list", notes = "Gets a specific task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}", method = RequestMethod.GET)
	@JsonView(View.TasklistWithTaskSummary.class)
	public ResponseEntity<TaskList> getTaskList(@PathVariable("listId") String listId) {
		return new ResponseEntity<>(taskListManager.getTaskList(listId), HttpStatus.OK);
	}

	/**
	 * API endpoint for creating a list for an authenticated user
	 * 
	 * @param taskList
	 * @return created {@link TaskList}
	 */
	@ApiOperation(value = "Create a custom task list", notes = "Creates a custom task list.", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TaskList> createTaskList(@RequestBody TaskList taskList) {
		return new ResponseEntity<>(taskListManager.createTaskList(taskList), HttpStatus.OK);
	}

	/**
	 * API endpoint for updating a list for an authenticated user
	 * 
	 * @param listId
	 * @param taskList
	 * @return updated {@link TaskList}
	 */
	@ApiOperation(value = "Update a task list", notes = "Updates a task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}", method = RequestMethod.PUT)
	@JsonView(View.TasklistWithTaskSummary.class)
	public ResponseEntity<TaskList> updateTaskList(@PathVariable("listId") String listId,
			@RequestBody TaskList taskList) {
		return new ResponseEntity<>(taskListManager.updateTaskList(listId, taskList), HttpStatus.OK);
	}

	/**
	 * API endpoint for deleting a list & associated tasks for an authenticated user
	 * 
	 * @param listId
	 * @return {@link List} of {@link DeleteDocument} containing list id and tasks
	 *         id that was deleted
	 */
	@ApiOperation(value = "Delete a task list", notes = "Deletes a task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}", method = RequestMethod.DELETE)
	@DeleteDocumentType(documentType = TaskList.class)
	public ResponseEntity<List<DeleteDocument>> deleteTaskList(@PathVariable("listId") String listId) {
		return new ResponseEntity<>(taskListManager.deleteTaskList(listId), HttpStatus.OK);
	}
}
