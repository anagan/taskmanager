/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.models;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Avinash
 *
 */
public class TaskList {

	@JsonIgnore
	private long id;

	@JsonView(View.TasklistWithTaskSummary.class)
	@JsonProperty("id")
	private String listId;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String title;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String parent;

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

	public TaskList() {
		this.due = Timestamp.from(Instant.EPOCH);
		this.createdTime = Timestamp.from(Instant.EPOCH);
		this.modifiedTime = Timestamp.from(Instant.EPOCH);
		this.trashedTime = Timestamp.from(Instant.EPOCH);;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the listId
	 */
	public String getListId() {
		return listId;
	}

	/**
	 * @param listId
	 *            the listId to set
	 */
	public void setListId(String listId) {
		this.listId = listId;
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
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
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
