package com.s2.travelmgt.repository;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.s2.travelmgt.model.TripDetails;

public interface TripInfoRepo extends CrudRepository<TripDetails, Long>  {

	@Query("Select t from trip_info t where t.custMobile=?1 or t.empMobile=?1")
	List<TripDetails> findByUsername(BigInteger username);
	
}