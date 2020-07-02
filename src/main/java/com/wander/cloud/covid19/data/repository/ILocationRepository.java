/**
 * 
 */
package com.wander.cloud.covid19.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wander.cloud.covid19.data.model.Location;

/**
 * @author SIVA KUMAR
 */
@Repository
public interface ILocationRepository extends PagingAndSortingRepository<Location, Integer> {

	Iterable<Location> findByStatus(Boolean status);
	Location findByName(String name);
}
