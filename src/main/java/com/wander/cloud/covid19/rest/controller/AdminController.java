/**
 * 
 */
package com.wander.cloud.covid19.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wander.cloud.covid19.rest.RequestPath;
import com.wander.cloud.covid19.rest.dto.CountryDTO;
import com.wander.cloud.covid19.rest.dto.LocationDTO;
import com.wander.cloud.covid19.service.impl.AdminService;

/**
 * @author SIVA KUMAR
 */
@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired AdminService adminService;

	@GetMapping(value = RequestPath.API + RequestPath.COUNTRY)
	public List<CountryDTO> handleInternalRequestForAllCountries() {
		return adminService.loadAllCountries();
	}

	@PostMapping(value = RequestPath.API + RequestPath.COUNTRY)
	public void handleInternalRequestForSaveCountry(@RequestBody CountryDTO dtoCountry) {
		adminService.saveCountry(dtoCountry);
	}

	@DeleteMapping(value = RequestPath.API + RequestPath.COUNTRY + RequestPath.ID)
	public void handleInternalRequestForDeleteCountry(@PathVariable Integer id) {
		adminService.deleteCountry(id);
	}

	@GetMapping(value = RequestPath.API + RequestPath.LOCATION)
	public List<LocationDTO> handleInternalRequestForAllLocations() {
		return adminService.loadAllLocations();
	}

	@PostMapping(value = RequestPath.API + RequestPath.LOCATION)
	public void handleInternalRequestForSaveLocation(@RequestBody LocationDTO dtoLocation) {
		adminService.saveLocation(dtoLocation);
	}

	@DeleteMapping(value = RequestPath.API + RequestPath.LOCATION + RequestPath.ID)
	public void handleInternalRequestForDeleteLocation(@PathVariable Integer id) {
		adminService.deleteLocation(id);
	}
}
