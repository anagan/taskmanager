/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.security;

import com.avinash.taskmanager.demo.tasks.models.User;

/**
 * @author Avinash
 *
 */
public interface IAuthenticationFacade {

	/**
	 * Returns logged in user details after request is processed by Spring security
	 * Authentication manager
	 * 
	 * @return {@link User} user details
	 */
	User getLoggedInUser();
}
