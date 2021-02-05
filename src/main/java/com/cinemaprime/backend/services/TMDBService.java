package com.cinemaprime.backend.services;

import com.cinemaprime.backend.apifetcher.ApiFetcher;
import com.cinemaprime.backend.dbmodels.moviemodels.Movie;
import com.cinemaprime.backend.dbmodels.moviemodels.MovieResults;
import com.cinemaprime.backend.enums.Region;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TMDBService {

    ApiFetcher af = new ApiFetcher();

    public String getUri() {
        return af.getUri();
    }

    public List<Movie> getMovies(String query) {
        MovieResults movieResults = new RestTemplate().getForObject(af.getUri("search/movie?query=" + query, true), MovieResults.class);
        assert movieResults != null;
        return movieResults.getResults();
    }

    public Movie getMovie(int id) {
        Movie movie = new RestTemplate().getForObject(af.getUri("/movie/" + id), Movie.class);
        assert movie != null;
        return movie;
    }

    public List<Movie> getRunning() {
        MovieResults movieResults = new RestTemplate().getForObject(af.getUri("movie/now_playing"), MovieResults.class);
        assert movieResults != null;
        return movieResults.getResults();
    }

    public List<Movie> getRunning(Region region) {
        String r = region.name();
        MovieResults movieResults = new RestTemplate().getForObject(af.getUri("movie/now_playing?region=" + r, true), MovieResults.class);
        assert movieResults != null;
        return movieResults.getResults();
    }
}
