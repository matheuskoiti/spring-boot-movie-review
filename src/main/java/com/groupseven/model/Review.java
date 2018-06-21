package com.groupseven.model;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Double score;

    private Integer movieId;

    private String description;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movie_id) {
        this.movieId = movie_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
