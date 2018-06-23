package com.groupseven.controller;

import com.groupseven.model.Movie;
import com.groupseven.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(path="/all")
    @CrossOrigin
    public @ResponseBody
    Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public @ResponseBody
    Movie getMovieById(@PathVariable(value = "id") Integer movieId) {
        return movieRepository.findById(movieId);
    }

}
