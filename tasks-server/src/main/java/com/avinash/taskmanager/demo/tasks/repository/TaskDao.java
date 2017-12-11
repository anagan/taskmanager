/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.avinash.taskmanager.demo.tasks.models.entity.TaskEntity;

/**
 * @author Avinash
 *
 */
public interface TaskDao extends JpaRepository<TaskEntity, String>, JpaSpecificationExecutor<TaskEntity> {

}
