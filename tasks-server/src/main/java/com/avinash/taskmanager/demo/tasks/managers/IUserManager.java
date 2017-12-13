/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers;

import com.avinash.taskmanager.demo.tasks.models.entity.UserEntity;

/**
 * @author Avinash
 *
 */
public interface IUserManager {

	UserEntity getLoggedInUser();
}
