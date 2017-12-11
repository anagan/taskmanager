/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.models;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Avinash
 *
 */
public class Task {

	@JsonView(View.TasklistWithTaskSummary.class)
	private String id;
	
	@JsonView(View.TasklistWithTaskSummary.class)
	private String title;
	
	private String parentId;
	
	@JsonView(View.TasklistWithTaskSummary.class)
	private String type;
	
	@JsonView(View.TasklistWithTaskSummary.class)
	private String position;
	
	@JsonView(View.TasklistWithTaskSummary.class)
	private Status status;
	
	@JsonView(View.TasklistWithTaskSummary.class)
	private Priority priority;
	
	private boolean hidden;
	
	@JsonView(View.TasklistWithTaskSummary.class)
	private Timestamp completed;
	
	private Timestamp createdTime;
	private Timestamp modifiedTime;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param title the title to set
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
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
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
	 * @param position the position to set
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
	 * @param status the status to set
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
	 * @param priority the priority to set
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
	 * @param hidden the hidden to set
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
	 * @param completed the completed to set
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
	 * @param createdTime the createdTime to set
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
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
