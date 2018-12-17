package com.foodServices.swaad.Repository;

import com.foodServices.swaad.Entity.TSP;
import org.springframework.data.repository.CrudRepository;

public interface TSPRepository extends CrudRepository<TSP,String> {

    TSP findByMsisdn(String msisdn);
}
