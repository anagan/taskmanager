/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;

/**
 * @author Avinash
 *
 */
public interface TaskListDao extends JpaRepository<TaskListEntity, String>, JpaSpecificationExecutor<TaskListEntity> {

}
