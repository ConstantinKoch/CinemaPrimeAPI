package com.cinemaprime.backend.dbmodels.cinemamodels;

import com.cinemaprime.backend.enums.Days;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.HashMap;

@Document
public class OpeningHours {
    HashMap<Days, HashMap<Integer, Integer>> openingHours = new HashMap<>();

    public OpeningHours() {}

    public void setOpeningHours(Days day, int opening, int closing) {
        HashMap<Integer, Integer> opened = new HashMap<>();
        opened.put(opening, closing);
        openingHours.put(day, opened);
    }
}
