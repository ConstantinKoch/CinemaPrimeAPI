package com.cinemaprime.backend.dao;

import com.cinemaprime.backend.dbmodels.cinemamodels.Cinema;
import com.cinemaprime.backend.dbmodels.cinemamodels.CinemaHall;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface CinemaHallRepository extends MongoRepository<CinemaHall, Integer> {

    List<CinemaHall> findCinemaHallsByCinema(Cinema cinema);
}
