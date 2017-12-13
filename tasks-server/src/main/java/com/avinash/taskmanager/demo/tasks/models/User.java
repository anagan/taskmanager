/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.models;

import java.sql.Timestamp;
import java.util.List;

import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Avinash
 *
 */
public class User {

	@JsonIgnore
	private String id;
	private String userId;
	private String givenName;
	private String familyName;
	private String emailId;
	private String password;
	private boolean active;
	private List<TaskListEntity> taskLists;
	private Timestamp createdTime;
	private Timestamp modifiedTime;

	public User() {
	}

	public User(String userId, boolean active) {
		this.userId = userId;
		this.active = active;
	}

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @param givenName
	 *            the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the taskLists
	 */
	public List<TaskListEntity> getTaskLists() {
		return taskLists;
	}

	/**
	 * @param taskLists
	 *            the taskLists to set
	 */
	public void setTaskLists(List<TaskListEntity> taskLists) {
		this.taskLists = taskLists;
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
