package com.cinemaprime.backend.dbmodels.screeningmodels;

import com.cinemaprime.backend.dbmodels.cinemamodels.CinemaHall;
import com.cinemaprime.backend.dbmodels.moviemodels.Movie;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Screening {
    @Id
    private int id;

    private int time;
    private int date;
    private CinemaHall cinemaHall;
    private Movie movie;
}
