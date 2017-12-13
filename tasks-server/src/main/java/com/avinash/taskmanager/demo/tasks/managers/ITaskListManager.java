/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.models.TaskList;
import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;

/**
 * @author Avinash
 *
 */
public interface ITaskListManager {

	Page<TaskList> getAllTaskLists(Pageable pageRequest);

	TaskList getTaskList(String taskListId);

	TaskList createTaskList(TaskList taskList);

	TaskList updateTaskList(String taskListId, TaskList taskList);

	List<DeleteDocument> deleteTaskList(String taskListId);
	
	TaskListEntity getTaskListEntity(String taskListId);
}
