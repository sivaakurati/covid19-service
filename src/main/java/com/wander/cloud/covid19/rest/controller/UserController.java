/**
 * 
 */
package com.wander.cloud.covid19.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wander.cloud.covid19.rest.RequestPath;
import com.wander.cloud.covid19.rest.dto.UserDTO;
import com.wander.cloud.covid19.service.IUserService;

/**
 * @author SIVA KUMAR
 */
@RestController
@CrossOrigin
public class UserController {

	@Autowired IUserService userService;

	@PostMapping(value = RequestPath.API + RequestPath.AUTHENTICATE)
	public UserDTO handleInternalRequestForUserAuthenticate(@RequestBody UserDTO dtoUser) {
		return userService.checkCredentials(dtoUser.getUsername(), dtoUser.getPassword());
	}

	@PostMapping(value = RequestPath.API + RequestPath.USER)
	public UserDTO handleInternalRequestForSaveUser(@RequestBody UserDTO dtoUser) {
		return userService.save(dtoUser);
	}
}
