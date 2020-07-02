/**
 * 
 */
package com.wander.cloud.covid19.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wander.cloud.covid19.data.model.Country;

/**
 * @author SIVA KUMAR
 */
@Repository
public interface ICountryRepository extends PagingAndSortingRepository<Country, Integer> {

	Iterable<Country> findByStatus(Boolean status);
	Country findByName(String name);
}
