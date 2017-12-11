/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.models;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Avinash
 *
 */
public class TaskList {

	@JsonView(View.TasklistWithTaskSummary.class)
	private String id;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String title;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String parentId;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String color;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String type;

	@JsonView(View.TasklistWithTaskSummary.class)
	private List<Task> tasks;

	@JsonView(View.TasklistWithTaskSummary.class)
	private boolean trashed;

	@JsonView(View.TasklistWithTaskSummary.class)
	private Timestamp due;

	@JsonView(View.TasklistWithTaskSummary.class)
	private Timestamp createdTime;

	@JsonView(View.TasklistWithTaskSummary.class)
	private Timestamp modifiedTime;

	@JsonView(View.TasklistWithTaskSummary.class)
	private Timestamp trashedTime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks
	 *            the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	/**
	 * @return the trashed
	 */
	public boolean isTrashed() {
		return trashed;
	}

	/**
	 * @param trashed
	 *            the trashed to set
	 */
	public void setTrashed(boolean trashed) {
		this.trashed = trashed;
	}

	/**
	 * @return the due
	 */
	public Timestamp getDue() {
		return due;
	}

	/**
	 * @param due
	 *            the due to set
	 */
	public void setDue(Timestamp due) {
		this.due = due;
	}

	/**
	 * @return the createdTime
	 */
	public Timestamp getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime
	 *            the createdTime to set
	 */
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the modifiedTime
	 */
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * @param modifiedTime
	 *            the modifiedTime to set
	 */
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	/**
	 * @return the trashedTime
	 */
	public Timestamp getTrashedTime() {
		return trashedTime;
	}

	/**
	 * @param trashedTime
	 *            the trashedTime to set
	 */
	public void setTrashedTime(Timestamp trashedTime) {
		this.trashedTime = trashedTime;
	}

}
