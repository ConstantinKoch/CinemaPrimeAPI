package com.cinemaprime.backend.dao;

import com.cinemaprime.backend.dbmodels.cinemamodels.Cinema;
import com.cinemaprime.backend.dbmodels.cinemamodels.CinemaHall;
import com.cinemaprime.backend.dbmodels.moviemodels.Movie;
import com.cinemaprime.backend.dbmodels.screeningmodels.Screening;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScreeningRepository extends MongoRepository<Screening, Integer> {
    List<Screening> findScreeningsByMovie(Movie movie);
    List<Screening> findScreeningsByCinemaHall(CinemaHall cinemaHall);
    List<Screening> findScreeningsByMovieAndCinemaHall_Cinema(Movie movie, Cinema cinema);
    List<Screening> findScreeningsByCinemaHall_Cinema(Cinema cinema);
    List<Screening> findScreeningsByCinemaHall_CinemaAndDate(Cinema cinema, int date);
    List<Screening> findScreeningsByMovie_Id(int id);
    List<Screening> findScreeningsByCinemaHall_Cinema_id(String id);
    List<Screening> findScreeningsByCinemaHall_Cinema_idAndMovie_Id(String cinemaHall_cinema_id, int movie_id);
}
