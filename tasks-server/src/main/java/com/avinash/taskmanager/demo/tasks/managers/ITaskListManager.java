/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers;

import java.util.List;

import com.avinash.taskmanager.demo.common.domains.DeleteDocument;
import com.avinash.taskmanager.demo.tasks.models.TaskList;

/**
 * @author Avinash
 *
 */
public interface ITaskListManager {

	List<TaskList> getAllTaskLists();

	TaskList getTaskList(String taskListId);

	TaskList createTaskList(TaskList taskList);

	TaskList updateTaskList(String taskListId, TaskList taskList);

	List<DeleteDocument> deleteTaskList(String taskListId);
}
