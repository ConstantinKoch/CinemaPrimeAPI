package com.cinemaprime.backend.dbmodels.screeningmodels;

import com.cinemaprime.backend.dbmodels.cinemamodels.CinemaHall;
import com.cinemaprime.backend.dbmodels.cinemamodels.Seat;
import com.cinemaprime.backend.dbmodels.moviemodels.Movie;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Screening {
    @Id
    private int id;

    private String time;
    private String date;
    private CinemaHall cinemaHall;
    private Movie movie;
    private Seat[][] seats;

    public Screening(int day, int month, int year, int hour, int minute, CinemaHall cinemaHall, Movie movie) {
        this.cinemaHall = cinemaHall;
        this.seats = cinemaHall.copySeats();
        this.movie = movie;
        this.date = day + "/" + month + "/" + year;
        this.time = hour + ":" + minute;
    }
}
