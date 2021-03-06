package com.groupseven.service;

import com.groupseven.model.Movie;
import com.groupseven.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Return all movies from database
     * @return
     */
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Return the movie specified by the id parameter
     * @param movieId
     * @return
     */
    public Movie getMovieById(Integer movieId) {
        return movieRepository.findById(movieId);
    }
}
