/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers;

import com.avinash.taskmanager.demo.tasks.models.entity.UserEntity;

/**
 * 
 * @author Avinash
 *
 */
public interface IUserManager {

	
	/**
	 * Fetch authenticated user details
	 * 
	 * @return {@link UserEntity} containing authenticated user details
	 */
	UserEntity getLoggedInUser();
}
