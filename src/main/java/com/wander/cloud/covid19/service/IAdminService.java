/**
 * 
 */
package com.wander.cloud.covid19.service;

import java.util.List;

import com.wander.cloud.covid19.rest.dto.CountryDTO;
import com.wander.cloud.covid19.rest.dto.LocationDTO;

/**
 * @author SIVA KUMAR
 */
public interface IAdminService {

	List<CountryDTO> loadAllCountries();
	CountryDTO saveCountry(CountryDTO dtoCountry);
	void deleteCountry(Integer id);
	CountryDTO loadCountryByName(String name);

	List<LocationDTO> loadAllLocations();
	LocationDTO saveLocation(LocationDTO dtoLocation);
	void deleteLocation(Integer id);
	LocationDTO loadLocationByName(String name);
}
