package com.foodServices.swaad.Repository;

import com.foodServices.swaad.Entity.TSP;
import com.foodServices.swaad.Entity.TSPItems;
import org.springframework.data.repository.CrudRepository;

public interface TSPItemsRepository extends CrudRepository<TSP,String> {

    Iterable<TSPItems> findByTspId(String tspId);
}
