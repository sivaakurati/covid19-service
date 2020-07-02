/**
 * 
 */
package com.wander.cloud.covid19.service;

import com.wander.cloud.covid19.rest.dto.UserDTO;

/**
 * @author SIVA KUMAR
 */
public interface IUserService {

	UserDTO save(UserDTO dtoUser);
	UserDTO checkCredentials(String username, String password);
	UserDTO loadByUsername(String username);
}
