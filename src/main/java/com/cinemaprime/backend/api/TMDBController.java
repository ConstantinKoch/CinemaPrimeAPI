package com.cinemaprime.backend.api;

import com.cinemaprime.backend.dbmodels.moviemodels.Movie;
import com.cinemaprime.backend.enums.Region;
import com.cinemaprime.backend.services.TMDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("tmdb")
@RestController
public class TMDBController {
    TMDBService tmdbService = new TMDBService();

    @GetMapping
    public String getUri() {
        return tmdbService.getUri();
    }

    @GetMapping("/find/{query}")
    public List<Movie> getMovies(@PathVariable("query") String query) {
        return tmdbService.getMovies(query);
    }

    @GetMapping("/findId/{id}")
    public Movie getMovieById(@PathVariable("id") int id) {return tmdbService.getMovie(id);}

    @GetMapping("running")
    public List<Movie> getRunningMovies() {
        return tmdbService.getRunning();
    }

    @GetMapping("running/{region}")
    public List<Movie> getRunningMovies(@PathVariable("region") Region region) {
        return tmdbService.getRunning(region);
    }
}
