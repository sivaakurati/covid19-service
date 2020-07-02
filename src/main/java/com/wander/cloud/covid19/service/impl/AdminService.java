/**
 * 
 */
package com.wander.cloud.covid19.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wander.cloud.covid19.data.model.Country;
import com.wander.cloud.covid19.data.model.Location;
import com.wander.cloud.covid19.data.repository.ICountryRepository;
import com.wander.cloud.covid19.data.repository.ILocationRepository;
import com.wander.cloud.covid19.rest.dto.CountryDTO;
import com.wander.cloud.covid19.rest.dto.LocationDTO;
import com.wander.cloud.covid19.service.IAdminService;
import com.wander.cloud.covid19.util.Constants;

/**
 * @author SIVA KUMAR
 */
@Service
public class AdminService implements IAdminService {

	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	@Autowired ICountryRepository countryRepository;
	@Autowired ILocationRepository locationRepository;

	@Override
	public List<CountryDTO> loadAllCountries() {
		List<CountryDTO> dtoCountries = new ArrayList<>();
		Iterable<Country> countries = countryRepository.findByStatus(Boolean.TRUE);
		countries.forEach(country -> {
			CountryDTO dtoCountry = new CountryDTO();
			dtoCountry.setId(country.getId());
			dtoCountry.setName(country.getName());
			dtoCountry.setIsd(country.getIsd());
			dtoCountry.setLastModifiedBy(country.getUpdatedBy());
			dtoCountry.setLastModifiedOn(country.getUpdatedOn().toString());
			dtoCountries.add(dtoCountry);
		});
		log.info(Constants.SELECT_LOG, new Throwable().getStackTrace()[0].getMethodName(), dtoCountries.size());
		return dtoCountries;
	}

	@Override
	public CountryDTO saveCountry(CountryDTO dtoCountry) {
		Country country = new Country();
		if (dtoCountry.getId() != 0) {
			Optional<Country> idOptionals = countryRepository.findById(dtoCountry.getId());
			if (idOptionals.isPresent())
				country = idOptionals.get();
			country.setId(dtoCountry.getId());
			country.setUpdatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			country.setUpdatedOn(new Date());
			log.info(Constants.UPDATE_LOG, new Throwable().getStackTrace()[0].getMethodName(), country.getName());
		} else {
			Country existingCountry = countryRepository.findByName(dtoCountry.getName());
			if (existingCountry != null) {
				country = existingCountry;
			} else {
				country.setCreatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
				country.setCreatedOn(new Date());
			}
			country.setUpdatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			country.setUpdatedOn(new Date());
			log.info(Constants.INSERT_LOG, new Throwable().getStackTrace()[0].getMethodName(), country.getName());
		}
		country.setName(dtoCountry.getName());
		country.setIsd(dtoCountry.getIsd());
		country.setStatus(Boolean.TRUE);
		countryRepository.save(country);
		return loadCountryByName(dtoCountry.getName());
	}

	@Override
	public void deleteCountry(Integer id) {
		Optional<Country> idOptionals = countryRepository.findById(id);
		if (idOptionals.isPresent()) {
			Country country = idOptionals.get();
			country.setStatus(Boolean.FALSE);
			log.info(Constants.DELETE_LOG, new Throwable().getStackTrace()[0].getMethodName(), country.getName());
			countryRepository.save(country);
		}
	}

	@Override
	public CountryDTO loadCountryByName(String name) {
		CountryDTO dtoCountry = new CountryDTO();
		Country country = countryRepository.findByName(name);
		dtoCountry.setId(country.getId());
		dtoCountry.setName(country.getName());
		dtoCountry.setIsd(country.getIsd());
		dtoCountry.setLastModifiedBy(country.getUpdatedBy());
		dtoCountry.setLastModifiedOn(country.getUpdatedOn().toString());
		log.info(Constants.SELECT_LOG, new Throwable().getStackTrace()[0].getMethodName(), dtoCountry.getName());
		return dtoCountry;
	}

	@Override
	public List<LocationDTO> loadAllLocations() {
		List<LocationDTO> dtoLocations = new ArrayList<>();
		Iterable<Location> locations = locationRepository.findByStatus(Boolean.TRUE);
		locations.forEach(location -> {
			LocationDTO dtoLocation = new LocationDTO();
			dtoLocation.setId(location.getId());
			dtoLocation.setName(location.getName());
			dtoLocation.setPin(location.getPin());
			dtoLocation.setCity(location.getCity());
			dtoLocation.setState(location.getState());
			dtoLocation.setCountry(location.getCountry());
			dtoLocation.setLastModifiedBy(location.getUpdatedBy());
			dtoLocation.setLastModifiedOn(location.getUpdatedOn().toString());
			dtoLocations.add(dtoLocation);
		});
		log.info(Constants.SELECT_LOG, new Throwable().getStackTrace()[0].getMethodName(), dtoLocations.size());
		return dtoLocations;
	}

	@Override
	public LocationDTO saveLocation(LocationDTO dtoLocation) {
		Location location = new Location();
		if (dtoLocation.getId() != 0) {
			Optional<Location> idOptionals = locationRepository.findById(dtoLocation.getId());
			if (idOptionals.isPresent())
				location = idOptionals.get();
			location.setId(dtoLocation.getId());
			location.setUpdatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			location.setUpdatedOn(new Date());
			log.info(Constants.UPDATE_LOG, new Throwable().getStackTrace()[0].getMethodName(), location.getName());
		} else {
			Location existingLocation = locationRepository.findByName(dtoLocation.getName());
			if (existingLocation != null) {
				location = existingLocation;
			} else {
				location.setCreatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
				location.setCreatedOn(new Date());
			}
			location.setUpdatedBy(System.getProperty(Constants.SYSTEM_USERNAME));
			location.setUpdatedOn(new Date());
			log.info(Constants.INSERT_LOG, new Throwable().getStackTrace()[0].getMethodName(), location.getName());
		}
		location.setName(dtoLocation.getName());
		location.setPin(dtoLocation.getPin());
		location.setCity(dtoLocation.getCity());
		location.setState(dtoLocation.getState());
		location.setCountry(dtoLocation.getCountry());
		location.setStatus(Boolean.TRUE);
		locationRepository.save(location);
		return loadLocationByName(dtoLocation.getName());
	}

	@Override
	public void deleteLocation(Integer id) {
		Optional<Location> idOptionals = locationRepository.findById(id);
		if (idOptionals.isPresent()) {
			Location location = idOptionals.get();
			location.setStatus(Boolean.FALSE);
			log.info(Constants.DELETE_LOG, new Throwable().getStackTrace()[0].getMethodName(), location.getName());
			locationRepository.save(location);
		}
	}

	@Override
	public LocationDTO loadLocationByName(String name) {
		LocationDTO dtoLocation = new LocationDTO();
		Location location = locationRepository.findByName(name);
		dtoLocation.setId(location.getId());
		dtoLocation.setName(location.getName());
		dtoLocation.setPin(location.getPin());
		dtoLocation.setCity(location.getCity());
		dtoLocation.setState(location.getState());
		dtoLocation.setCountry(location.getCountry());
		dtoLocation.setLastModifiedBy(location.getUpdatedBy());
		dtoLocation.setLastModifiedOn(location.getUpdatedOn().toString());
		log.info(Constants.SELECT_LOG, new Throwable().getStackTrace()[0].getMethodName(), dtoLocation.getName());
		return dtoLocation;
	}
}
