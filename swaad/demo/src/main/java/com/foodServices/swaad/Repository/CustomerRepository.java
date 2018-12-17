package com.foodServices.swaad.Repository;

import com.foodServices.swaad.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,String> {

    Customer findByMsisdn(String msisdn);
}
