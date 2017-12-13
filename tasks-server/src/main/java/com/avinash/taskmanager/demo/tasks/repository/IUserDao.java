/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avinash.taskmanager.demo.tasks.models.entity.UserEntity;

/**
 * @author Avinash
 *
 */
@Repository
public interface IUserDao extends JpaRepository<UserEntity, String> {

	UserEntity findByUserId(String userId);
}
