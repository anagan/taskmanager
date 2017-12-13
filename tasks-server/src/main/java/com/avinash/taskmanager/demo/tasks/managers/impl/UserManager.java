/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.managers.impl;

import java.sql.Timestamp;
import java.time.Instant;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.taskmanager.demo.tasks.execptions.InActiveUserException;
import com.avinash.taskmanager.demo.tasks.execptions.NotFoundException;
import com.avinash.taskmanager.demo.tasks.managers.IUserManager;
import com.avinash.taskmanager.demo.tasks.models.User;
import com.avinash.taskmanager.demo.tasks.models.entity.UserEntity;
import com.avinash.taskmanager.demo.tasks.repository.IUserDao;
import com.avinash.taskmanager.demo.tasks.security.IAuthenticationFacade;

/**
 * @author Avinash
 *
 */
@Service
public class UserManager implements IUserManager {

	@Autowired
	IAuthenticationFacade authentication;

	@Autowired
	IUserDao userDao;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserEntity getLoggedInUser() {
		User user = authentication.getLoggedInUser();
		UserEntity userEntity = convertToEntity(user);

		if (null == userEntity || StringUtils.isEmpty(userEntity.getUserId())) {
			throw new NotFoundException("Invalid user");
		}
		
		if (!userEntity.isActive()) {
			throw new InActiveUserException("Inactive user '" + userEntity.getUserId() + "'");
		}

		UserEntity persistedUserEntity = userDao.findByUserId(userEntity.getUserId());
		if (null != persistedUserEntity) {
			persistedUserEntity.setGivenName(userEntity.getGivenName());
			persistedUserEntity.setFamilyName(userEntity.getFamilyName());
			persistedUserEntity.setEmailId(userEntity.getEmailId());
			persistedUserEntity.setPassword(userEntity.getPassword());
			persistedUserEntity.setActive(userEntity.isActive());
		} else {
			persistedUserEntity = userEntity;
			persistedUserEntity.setActive(true);
		}
		
		return userDao.save(persistedUserEntity);
	}

	private UserEntity convertToEntity(User user) {

		if (null == user) {
			return null;
		}

		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		userEntity
				.setCreatedTime(null == user.getCreatedTime() ? Timestamp.from(Instant.now()) : user.getCreatedTime());
		return userEntity;
	}
}
