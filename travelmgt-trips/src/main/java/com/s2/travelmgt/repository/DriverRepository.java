package com.s2.travelmgt.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.s2.travelmgt.model.Driver;


public interface DriverRepository extends CrudRepository<Driver, Long> {
    @Query(nativeQuery=true, value="SELECT * FROM Driver q where q.status > 0")
    public Collection<Driver> findDriver();
}
