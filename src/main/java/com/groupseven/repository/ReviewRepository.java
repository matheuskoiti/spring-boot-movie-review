package com.groupseven.repository;

import com.groupseven.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByMovieId(Integer movieId);
}
