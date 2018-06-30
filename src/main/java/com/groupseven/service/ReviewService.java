package com.groupseven.service;

import com.groupseven.model.Movie;
import com.groupseven.model.Review;
import com.groupseven.repository.MovieRepository;
import com.groupseven.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getAllReviewsByMovieId(Integer movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public double getMovieAverageScore(Integer movieId) {
        List<Review> listReview = reviewRepository.findByMovieId(movieId);

        double soma = 0;

        for (int i = 0; i < listReview.size(); i++) {
            soma += listReview.get(i).getScore();
        }

        if (listReview.size() == 0) {
            return 0;
        } else {
            return soma/listReview.size();
        }
    }

    public Review createReview (Double score, String description, Integer movieId) {
        Movie movie = movieRepository.findById(movieId);

        Review review = new Review();
        review.setScore(score);
        review.setDescription(description);
        review.setMovie(movie);

        return reviewRepository.save(review);
    }
}
