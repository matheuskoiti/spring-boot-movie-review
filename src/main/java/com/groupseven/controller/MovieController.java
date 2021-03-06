package com.groupseven.controller;

import com.groupseven.model.Movie;
import com.groupseven.repository.MovieRepository;
import com.groupseven.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Return all movies from database
     * @return
     */
    @GetMapping(path="/all")
    @CrossOrigin
    public @ResponseBody
    Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    /**
     * Return only the movie specified by id
     * @param movieId
     * @return
     */
    @GetMapping("/{id}")
    @CrossOrigin
    public @ResponseBody
    Movie getMovieById(@PathVariable(value = "id") Integer movieId) {
        return movieService.getMovieById(movieId);
    }

}
