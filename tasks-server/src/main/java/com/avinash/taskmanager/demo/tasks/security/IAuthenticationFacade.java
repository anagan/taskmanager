/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.avinash.taskmanager.demo.tasks.models.User;

/**
 * @author Avinash
 *
 */
public interface IAuthenticationFacade {

	Authentication getAuthentication();

	UserDetails getUserDetails();
	
	User getLoggedInUser();
}
