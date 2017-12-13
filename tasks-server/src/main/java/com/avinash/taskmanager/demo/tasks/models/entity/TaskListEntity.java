/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.models.entity;

import static com.avinash.taskmanager.demo.tasks.utilities.CommonUtil.UUID;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Avinash
 *
 */
@Entity
@Table(name = "tasklists")
public class TaskListEntity {

	private long id;
	private String listId;
	private String title;
	private String parent;
	private String color;
	private String type;
	private UserEntity user;
	private List<TaskEntity> tasks;
	private boolean trashed;
	private Timestamp createdTime;
	private Timestamp modifiedTime;
	private Timestamp trashedTime;

	public TaskListEntity() {
		this.listId = UUID();
	}

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
	 * @return the listId
	 */
	@Column(unique = true, nullable = false)
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
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinColumn(name = "user_ref_id", updatable = false)
	public UserEntity getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * @return the tasks
	 */
	@OneToMany(mappedBy = "parId", cascade = CascadeType.ALL)
	@Column(updatable = false)
	public List<TaskEntity> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks
	 *            the tasks to set
	 */
	public void setTasks(List<TaskEntity> tasks) {
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
	 * @return the createdTime
	 */
	@Column(updatable = false)
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
