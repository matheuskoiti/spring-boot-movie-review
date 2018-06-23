package com.groupseven.repository;

import com.groupseven.model.Movie;
import com.groupseven.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findById(Integer movieId);
}
