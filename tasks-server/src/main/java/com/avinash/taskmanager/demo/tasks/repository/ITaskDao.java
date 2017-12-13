/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.avinash.taskmanager.demo.tasks.models.entity.TaskEntity;

/**
 * @author Avinash
 *
 */
@Repository
public interface ITaskDao extends JpaRepository<TaskEntity, String>, JpaSpecificationExecutor<TaskEntity> {

}
