/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.security.impl;

import java.util.Map;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import com.avinash.taskmanager.demo.tasks.models.User;
import com.avinash.taskmanager.demo.tasks.security.IAuthenticationFacade;

/**
 * @author Avinash
 *
 */
@Component
public class AuthenticationFacade implements IAuthenticationFacade {
	
	/* (non-Javadoc)
	 * @see com.avinash.taskmanager.demo.tasks.security.IAuthenticationFacade#getLoggedInUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User getLoggedInUser() {

		User user = null;

		Authentication authentication = getAuthentication();

		if (authentication instanceof AnonymousAuthenticationToken || null == authentication.getPrincipal()) {
			throw new UnauthorizedUserException("Unauthorized user");
		}
		
		if (authentication instanceof OAuth2Authentication) {
			OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) oAuth2Authentication
					.getUserAuthentication();
			Map<String, Object> map = (Map<String, Object>) token.getDetails();
			user = fromMap(map);
		}

		return user;
	}

	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	private User fromMap(Map<String, Object> map) {
		User user = new User();
		user.setGivenName((String) map.get("given_name"));
		user.setFamilyName((String) map.get("family_name"));
		user.setEmailId((String) map.get("email"));
		user.setUserId((String) (map.containsKey("id") ? map.get("id") : map.get("sub")));
		user.setActive(true);
		return user;
	}
}
