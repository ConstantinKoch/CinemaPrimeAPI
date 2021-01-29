package com.cinemaprime.backend.dao;

import com.cinemaprime.backend.dbmodels.cinemamodels.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends MongoRepository<Cinema, String> {

    Cinema findByName(String name);
    Optional<Cinema> findById(String id);
    List<Cinema> findAll();
}
