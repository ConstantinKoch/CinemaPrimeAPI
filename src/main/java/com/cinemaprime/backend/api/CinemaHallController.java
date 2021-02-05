package com.cinemaprime.backend.api;

import com.cinemaprime.backend.dao.CinemaHallRepository;
import com.cinemaprime.backend.dao.CinemaRepository;
import com.cinemaprime.backend.dbmodels.cinemamodels.Cinema;
import com.cinemaprime.backend.dbmodels.cinemamodels.CinemaHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("cinemahall")
@RestController
public class CinemaHallController {

        @Autowired
        CinemaHallRepository repository;

        @Autowired
        CinemaRepository cinemaRepository;

        @GetMapping("create")
        public CinemaHall createCH() {
                System.out.println(cinemaRepository.findCinemaByName("Kino Example"));

                Cinema cinema = cinemaRepository.findCinemaByName("Kino Example");

                if (cinema == null) {
                      cinema = new Cinema("Kino Example");
                      cinemaRepository.save(cinema);
                }

                Optional<CinemaHall> ch = repository.findCinemaHallsByCinema(cinema).stream().filter(cinemaHall -> cinemaHall.getName().equals("Example")).findFirst();

                CinemaHall chr;

                if (!ch.isPresent()) {
                        chr = new CinemaHall("Example", cinema, 20, 20);
                        repository.save(chr);
                } else {
                        chr = ch.get();
                }

                return chr;
        }

}
