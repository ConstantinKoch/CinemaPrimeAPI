package com.cinemaprime.backend.api;

import com.cinemaprime.backend.dao.ScreeningRepository;
import com.cinemaprime.backend.dbmodels.screeningmodels.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("screening")
@RestController
public class ScreeningController {

    @Autowired
    ScreeningRepository repository;

    @GetMapping("/cinema/{id}")
    public List<Screening> getScreeningsByCinema(@PathVariable("id") String id) {
        return repository.findScreeningsByCinemaHall_Cinema_id(id);
    }

    @GetMapping("/cinema/{id}/movie/{mId}")
    public List<Screening> getScreeningsByCinemaAndMovie(@PathVariable("id") String id, @PathVariable("mId") int mId) {
        return repository.findScreeningsByCinemaHall_Cinema_idAndMovie_Id(id, mId);
    }

    @GetMapping("/movie/{id}")
    public List<Screening> getScreeningsByMovie(@PathVariable("id") int id) {
        return repository.findScreeningsByMovie_Id(id);
    }

}
