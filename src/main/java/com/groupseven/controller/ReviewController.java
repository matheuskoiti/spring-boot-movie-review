package com.groupseven.controller;

import com.groupseven.model.Movie;
import com.groupseven.model.Review;
import com.groupseven.repository.MovieRepository;
import com.groupseven.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(path="/all")
    @CrossOrigin
    public @ResponseBody
    Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping(path="/add")
    @CrossOrigin
    public @ResponseBody Review createReview (@RequestParam Double score,
                                            @RequestParam String description,
                                            @RequestParam Integer movieId) {
      Review review = new Review();
      review.setScore(score);
      review.setDescription(description);

      Movie movie = movieRepository.findById(movieId);

      review.setMovie(movie);

      return reviewRepository.save(review);
    }

    @GetMapping("/movie/{movieId}")
    @CrossOrigin
    public @ResponseBody
    List<Review> getAllReviewsByMovieId(@PathVariable (value = "movieId") Integer movieId) {
        return reviewRepository.findByMovieId(movieId);
    }
}
