package com.driver.model;

public class Director {
    private String directorName;

    public Director(){

    }

    public Director(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
