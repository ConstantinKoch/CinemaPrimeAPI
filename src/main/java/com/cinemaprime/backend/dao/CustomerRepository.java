package com.cinemaprime.backend.dao;

import com.cinemaprime.backend.dbmodels.usermodels.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    
    Customer findByFirstname(String firstname);
    Customer findByEmail(String email);
    // Person findByLastname(String lastname);

}
