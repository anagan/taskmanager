/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.avinash.taskmanager.demo.tasks.models.entity.UserEntity;
import com.avinash.taskmanager.demo.tasks.repository.IUserDao;

/**
 * @author Avinash
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoTest extends ApplicationTests {

	private static final String USER_ID = "1122112211";
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	private TestEntityManager entityManager;

	
	@Test
	public void whenFindByUserId_thenReturnUserEntity() {
		
		UserEntity user = new UserEntity();
	    user.setGivenName("John");
	    user.setFamilyName("Doe");
	    user.setActive(true);
	    user.setCreatedTime(Timestamp.from(Instant.now()));
	    user.setUserId(USER_ID);
	    user.setId(1);
	  
	    entityManager.merge(user);
	    entityManager.flush();
	    
		String givenName = "John";
		UserEntity userEntity = userDao.findByUserId(USER_ID);
		assertThat(userEntity.getGivenName()).isEqualTo(givenName);
	}
}
