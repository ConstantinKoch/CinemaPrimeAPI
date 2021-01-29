package com.cinemaprime.backend.api;

import com.cinemaprime.backend.dao.CinemaRepository;
import com.cinemaprime.backend.dbmodels.cinemamodels.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("cinema")
@RestController
public class CinemaController {

    @Autowired
    CinemaRepository repository;

    @GetMapping("/name/{name}")
    public Cinema getCinema(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Cinema getCinemaById(@PathVariable("id") String id) {
        Optional<Cinema> cinema = repository.findById(id);
        if (!cinema.isPresent()) {
            throw new CinemaNotFoundException();
        }
        return cinema.get();
    }

    @PostMapping
    public void addCinema(@RequestBody Cinema cinema) {
        repository.save(cinema);
    }

    @GetMapping
    public void findAll() {repository.findAll();}
}

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cinema not found")
class CinemaNotFoundException extends RuntimeException {}
