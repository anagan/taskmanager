/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.models;

import java.sql.Timestamp;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Avinash
 *
 */
public class Task {

	@JsonIgnore
	private long id;
	
	@JsonView(View.TasklistWithTaskSummary.class)
	@JsonProperty("id")
	private String taskId;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String title;

	@JsonView(View.TaskInternal.class)
	private String parId;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String type;

	@JsonView(View.TasklistWithTaskSummary.class)
	private String position;

	@JsonView(View.TasklistWithTaskSummary.class)
	private Status status;

	@JsonView(View.TasklistWithTaskSummary.class)
	private Priority priority;

	@JsonView(View.TaskInternal.class)
	private boolean hidden;

	@JsonView(View.TasklistWithTaskSummary.class)
	private Timestamp completed;

	@JsonView(View.TaskInternal.class)
	private Timestamp createdTime;
	
	@JsonView(View.TaskInternal.class)
	private Timestamp modifiedTime;

	public Task() {
		this.createdTime = Timestamp.from(Instant.EPOCH);
		this.modifiedTime = Timestamp.from(Instant.EPOCH);
		this.completed = Timestamp.from(Instant.EPOCH);
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
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
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
	 * @return the parId
	 */
	public String getParId() {
		return parId;
	}

	/**
	 * @param parId
	 *            the parId to set
	 */
	public void setParId(String parId) {
		this.parId = parId;
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
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	/**
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * @param hidden
	 *            the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * @return the completed
	 */
	public Timestamp getCompleted() {
		return completed;
	}

	/**
	 * @param completed
	 *            the completed to set
	 */
	public void setCompleted(Timestamp completed) {
		this.completed = completed;
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

}
