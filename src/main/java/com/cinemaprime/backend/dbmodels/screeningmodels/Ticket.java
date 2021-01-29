package com.cinemaprime.backend.dbmodels.screeningmodels;

import com.cinemaprime.backend.dbmodels.cinemamodels.Seat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {
    @Id
    private int ticketId;

    private double price;
    private Screening screening;
    private Seat seat;
    private boolean available;
}
