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
        return title + "\t" + yearPublished + "\t" + director + "\t" + movieRating + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Movie movie = (Movie) o;

        if (yearPublished != null ? !yearPublished.equals(movie.yearPublished) : movie.yearPublished != null)
            return false;
        if (director != null ? !director.equals(movie.director) : movie.director != null)
            return false;
        return !(movieRating != null ? !movieRating.equals(movie.movieRating) : movie.movieRating != null);

    }

    @Override
    public int hashCode() {
        int result = yearPublished != null ? yearPublished.hashCode() : 0;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (movieRating != null ? movieRating.hashCode() : 0);
        return result;
    }
}
