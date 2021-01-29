package com.cinemaprime.backend.dbmodels.cinemamodels;

import com.cinemaprime.backend.dbmodels.cinemamodels.CinemaHall;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seat {
    @Id
    private int id;
    private int row;
    private int col;
    private CinemaHall in;

    public Seat(int row, int col, CinemaHall in) {
        this.row = row;
        this.col = col;
        this.in = in;
    }
}
