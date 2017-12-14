/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.taskmanager.demo.common.annotations.DeleteDocumentType;
import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.managers.ITaskManager;
import com.avinash.taskmanager.demo.tasks.models.Task;
import com.avinash.taskmanager.demo.tasks.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

/**
 * Provides APIs for creating & managing tasks
 * 
 * @author Avinash
 *
 */
@RestController
@RequestMapping("/api/v1/lists")
public class TaskController {

	@Autowired
	private ITaskManager taskManager;

	/**
	 * API endpoint for fetching all tasks for a list identified by listId
	 * 
	 * @param listId
	 * @return {@link List} of tasks for {@linkplain listId}
	 */
	@ApiOperation(value = "Get all tasks in the specified task list", notes = "Gets all tasks in the specified task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}/tasks", method = RequestMethod.GET)
	@JsonView(View.TasklistWithTaskSummary.class)
	public ResponseEntity<List<Task>> getAllTasks(@PathVariable("listId") String listId) {
		return new ResponseEntity<>(taskManager.getAllTasks(listId), HttpStatus.OK);
	}

	/**
	 * API endpoint for fetching task by taskId for a list identified by listId
	 * 
	 * @param listId
	 * @param taskId
	 * @return {@link Task}
	 */
	@ApiOperation(value = "Get a specific task in the specified task list", notes = "Gets a specific task in the specified task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}/tasks/{taskId}", method = RequestMethod.GET)
	@JsonView(View.TasklistWithTaskSummary.class)
	public ResponseEntity<Task> getTask(@PathVariable("listId") String listId, @PathVariable("taskId") String taskId) {
		return new ResponseEntity<>(taskManager.getTask(listId, taskId), HttpStatus.OK);
	}

	/**
	 * API endpoint for creating a task for a list identified by listId
	 * 
	 * @param listId
	 * @param task
	 * @return created {@link Task}
	 */
	@ApiOperation(value = "Create a custom task in the specified task list", notes = "Creates a custom task in the specified task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}/tasks", method = RequestMethod.POST)
	public ResponseEntity<Task> createTask(@PathVariable("listId") String listId, @RequestBody Task task) {
		return new ResponseEntity<>(taskManager.createTask(listId, task), HttpStatus.OK);
	}

	/**
	 *  API endpoint for updating a task for a list identified by listId
	 * 
	 * @param listId
	 * @param taskId
	 * @param task
	 * @return updated {@link Task}
	 */
	@ApiOperation(value = "Update a task in the specified task list", notes = "Updates a task in the specified task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}/tasks/{taskId}", method = RequestMethod.PUT)
	@JsonView(View.TasklistWithTaskSummary.class)
	public ResponseEntity<Task> updateTask(@PathVariable("listId") String listId, @PathVariable("taskId") String taskId,
			@RequestBody Task task) {
		return new ResponseEntity<>(taskManager.updateTask(listId, taskId, task), HttpStatus.OK);
	}

	/**
	 *  API endpoint for deleting a task for a list identified by listId
	 * 
	 * @param listId
	 * @param taskId
	 * @return {@link DeleteDocument} containing deleted task id
	 */
	@ApiOperation(value = "Delete a task in the specified task list", notes = "Deletes a task in the specified task list.", response = ResponseEntity.class)
	@RequestMapping(value = "/{listId}/tasks/{taskId}", method = RequestMethod.DELETE)
	@DeleteDocumentType(documentType = Task.class)
	public ResponseEntity<List<DeleteDocument>> deleteTask(@PathVariable("listId") String listId,
			@PathVariable("taskId") String taskId) {
		return new ResponseEntity<>(taskManager.deleteTask(listId, taskId), HttpStatus.OK);
	}
}
