package com.cinemaprime.backend.dbmodels.cinemamodels;

import com.cinemaprime.backend.dbmodels.Adress;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cinemas")
public class Cinema {

    @Id
    public String id;

    private String name;
    private Adress adress;
    private int parkingSlots;
    private OpeningHours openingHours;
    // private List<CinemaHall> cinemaHalls;

    public Cinema() {}

    public Cinema(String name) {
        this.name = name;
    }

    public Cinema(String name, int parkingSlots, OpeningHours openingHours){
        this.name = name;
        this.parkingSlots = parkingSlots;
        this.openingHours = openingHours;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public boolean isOpen() {
        return false;
    }
}
