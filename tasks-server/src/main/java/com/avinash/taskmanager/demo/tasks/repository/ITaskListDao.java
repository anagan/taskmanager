/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avinash.taskmanager.demo.tasks.models.entity.TaskListEntity;

/**
 * @author Avinash
 *
 */
@Repository
public interface ITaskListDao extends JpaRepository<TaskListEntity, String> {

	Page<TaskListEntity> findByUser_userIdAndTrashedFalse(String userId, Pageable pageRequest);
	
	@Query(value = "select case when count(t) > 0 then true else false end from TaskListEntity t, UserEntity u "
			+ "where t.user.id = u.id and t.id = :id and u.userId = :userId")
	boolean isAuthorized(@Param("id") Long id, @Param("userId") String userId);

	TaskListEntity findByListIdAndTrashedFalse(String taskListId);

}
