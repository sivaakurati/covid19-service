/**
 * 
 */
package com.wander.cloud.covid19.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wander.cloud.covid19.data.model.User;

/**
 * @author SIVA KUMAR
 */
@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {

	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
