/**
 * 
 */
package com.wander.cloud.covid19.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wander.cloud.covid19.data.model.User;
import com.wander.cloud.covid19.data.repository.IUserRepository;
import com.wander.cloud.covid19.rest.dto.UserDTO;
import com.wander.cloud.covid19.service.IUserService;
import com.wander.cloud.covid19.util.Constants;

/**
 * @author SIVA KUMAR
 */
@Service
public class UserService implements IUserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired IUserRepository userRepository;

	@Override
	public UserDTO checkCredentials(String username, String password) {
		UserDTO dtoUser = new UserDTO();
		User user = userRepository.findByUsernameAndPassword(username, password);
		dtoUser.setId(user.getId());
		dtoUser.setName(user.getName());
		dtoUser.setUsername(user.getUsername());
		dtoUser.setAccess(user.getAccess());
		log.info(Constants.SELECT_USER_LOG, new Throwable().getStackTrace()[0].getMethodName(), dtoUser.getUsername());
		return dtoUser;
	}

	@Override
	public UserDTO save(UserDTO dtoUser) {
		User user = new User();
		user.setName(dtoUser.getName());
		user.setUsername(dtoUser.getUsername());
		user.setPassword(dtoUser.getPassword());			
		User existingUser = userRepository.findByUsername(dtoUser.getUsername());
		if (existingUser != null) {
			user.setId(existingUser.getId());
			user.setName(existingUser.getName());
			user.setPassword(existingUser.getPassword());
		}
		user.setAccess(dtoUser.getAccess());
		userRepository.save(user);
		log.info(Constants.INSERT_USER_LOG, new Throwable().getStackTrace()[0].getMethodName(), user.getUsername());
		return loadByUsername(dtoUser.getUsername());
	}

	@Override
	public UserDTO loadByUsername(String username) {
		UserDTO dtoUser = new UserDTO();
		User user = userRepository.findByUsername(username);
		if (null != user) {
			dtoUser.setId(user.getId());
			dtoUser.setName(user.getName());
			dtoUser.setUsername(user.getUsername());
			dtoUser.setAccess(user.getAccess());
			log.info(Constants.SELECT_USER_LOG, new Throwable().getStackTrace()[0].getMethodName(), dtoUser.getUsername());
		}
		return dtoUser;
	}
}
