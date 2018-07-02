package com.groupseven.controller;

import com.groupseven.model.Review;
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

    /**
     * Return all reviews from database
     * @return
     */
    @GetMapping(path="/all")
    @CrossOrigin
    public @ResponseBody
    Iterable<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    /**
     * Add a new review
     * @param score
     * @param description
     * @param movieId
     * @return
     */
    @GetMapping(path="/add")
    @CrossOrigin
    public @ResponseBody Review createReview (@RequestParam Double score,
                                            @RequestParam String description,
                                            @RequestParam Integer movieId) {

      return reviewService.createReview (score, description, movieId);
    }

    /**
     * Return a review that has the id movieId
     * @param movieId
     * @return
     */
    @GetMapping("/movie/{movieId}")
    @CrossOrigin
    public @ResponseBody
    List<Review> getAllReviewsByMovieId(@PathVariable (value = "movieId") Integer movieId) {
        return reviewService.getAllReviewsByMovieId(movieId);
    }

    /**
     * Return the average score from the movie
     * @param movieId
     * @return
     */
    @GetMapping("/average-score/movie/{movieId}")
    @CrossOrigin
    public @ResponseBody
    Double getAverageScoreReviews(@PathVariable (value = "movieId") Integer movieId) {
        return reviewService.getMovieAverageScore(movieId);
    }
}
