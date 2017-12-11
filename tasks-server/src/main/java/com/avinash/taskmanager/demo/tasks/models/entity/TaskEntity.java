/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.models.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avinash.taskmanager.demo.tasks.models.Priority;
import com.avinash.taskmanager.demo.tasks.models.Status;

/**
 * @author Avinash
 *
 */
@Entity
@Table(name = "tasks")
public class TaskEntity {

	private long id;
	private String taskId;
	private String title;
	private TaskListEntity parent;
	private String type;
	private String position;
	private Status status;
	private Priority priority;
	private boolean hidden;
	private Timestamp completedTime;
	private Timestamp createdTime;
	private Timestamp modifiedTime;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param taskId the taskId to set
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
	 * @return the parent
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tasklist_ref_id")
	public TaskListEntity getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(TaskListEntity parent) {
		this.parent = parent;
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
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
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
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
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
	 * @return the completedTime
	 */
	public Timestamp getCompletedTime() {
		return completedTime;
	}

	/**
	 * @param completedTime
	 *            the completedTime to set
	 */
	public void setCompletedTime(Timestamp completedTime) {
		this.completedTime = completedTime;
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
