package com.twu.biblioteca;

public class Movie extends Item {
    private String yearPublished;
    private String director;
    private String movieRating;

    public Movie(String title, String yearPublished, String director, String movieRating) {
        this.title = title;
        this.yearPublished = yearPublished;
        this.director = director;
        this.movieRating = movieRating;
    }

    public String getDetails() {
        return title + "\t" + yearPublished + "\t" + director + "\t" + movieRating;
    }
}
