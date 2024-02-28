package com.driver.model;

public class DirectorMoviePair {
    private String movieName;
    private String directorName;

    public DirectorMoviePair(){

    }

    public DirectorMoviePair(String movieName, String directorName) {
        this.movieName = movieName;
        this.directorName = directorName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
