package com.groupseven.controller;

import com.groupseven.model.Movie;
import com.groupseven.model.Review;
import com.groupseven.repository.MovieRepository;
import com.groupseven.repository.ReviewRepository;
import com.groupseven.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping(path="/all")
    @CrossOrigin
    public @ResponseBody
    Iterable<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping(path="/add")
    @CrossOrigin
    public @ResponseBody Review createReview (@RequestParam Double score,
                                            @RequestParam String description,
                                            @RequestParam Integer movieId) {

      return reviewService.createReview (score, description, movieId);
    }

    @GetMapping("/movie/{movieId}")
    @CrossOrigin
    public @ResponseBody
    List<Review> getAllReviewsByMovieId(@PathVariable (value = "movieId") Integer movieId) {
        return reviewService.getAllReviewsByMovieId(movieId);
    }

    @GetMapping("/average-score/movie/{movieId}")
    @CrossOrigin
    public @ResponseBody
    Double getAverageScoreReviews(@PathVariable (value = "movieId") Integer movieId) {
        return reviewService.getMovieAverageScore(movieId);
    }
}
