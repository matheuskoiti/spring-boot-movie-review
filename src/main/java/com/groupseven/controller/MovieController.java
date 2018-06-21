package com.groupseven.controller;

import com.groupseven.model.Movie;
import com.groupseven.repository.MovieRepository;
import com.groupseven.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
