package com.cinemaprime.backend.api;

import com.cinemaprime.backend.dao.CinemaRepository;
import com.cinemaprime.backend.dbmodels.cinemamodels.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("cinemahall")
@RestController
public class CinemaHallController {

        @Autowired
        CinemaRepository repository;

        @GetMapping("/name/{name}")
        public Cinema getCinema(@PathVariable("name") String name) {
            return repository.findByName(name);
        }

}
