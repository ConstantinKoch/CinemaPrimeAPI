package com.cinemaprime.backend.dbmodels.cinemamodels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CinemaHall {
    @Id
    private int id;

    private String name;

    private Seat[][] seats;
    private Cinema cinema;

    public CinemaHall(String name, Cinema cinema, int rows, int cols) {
        this.name = name;
        this.cinema = cinema;
        seats = new Seat[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = new Seat(i+1, j+1, this);
            }
        }
    }

    public Seat[][] copySeats() {
        return this.seats.clone();
    }

    public String getName() {
        return name;
    }
}
