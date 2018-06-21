package com.groupseven.controller;

import com.groupseven.model.Review;
import com.groupseven.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping(path="/add")
    public @ResponseBody String createReview (@RequestParam Double score,
                                            @RequestParam String description,
                                            @RequestParam Integer movieId) {
      Review review = new Review();
      review.setScore(score);
      review.setDescription(description);
      review.setMovieId(movieId);

      reviewRepository.save(review);

      return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/movie/{movieId}")
    public @ResponseBody
    List<Review> getAllReviewsByMovieId(@PathVariable (value = "movieId") Integer movieId) {
        return reviewRepository.findByMovieId(movieId);
    }
}
