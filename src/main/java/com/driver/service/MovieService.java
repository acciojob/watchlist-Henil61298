package com.driver.service;

import com.driver.model.Director;
import com.driver.model.DirectorMoviePair;
import com.driver.model.Movie;
import com.driver.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    Movie movie;
    Director director;
    static List<Movie> movieList = new ArrayList<>();
    static List<Director> directorList = new ArrayList<>();
    MovieRepository movieRepository = new MovieRepository();

    static {
        movieList.add(new Movie("Avengers"));
        movieList.add(new Movie("KGF"));
        movieList.add(new Movie("Sonu ke Titu ki Sweety"));
        directorList.add(new Director("Ravindranath Tagore"));
        directorList.add(new Director("Mahatma Gandhi"));
        directorList.add(new Director("Doraemon"));
    }

    public String addMovie(Movie m){
        if (!movieList.contains(m)){
            movieList.add(m);
        }

        return "Movie Added";
    }

    public String addDirector(Director d){
        if (directorList.contains(d)){
            return "Present";
        }
        directorList.add(director);
        return "Success";
    }

    public String addPair(DirectorMoviePair d){
        return movieRepository.pairDirectorMovie(movieList, directorList, d);
    }

    public Movie getMovie(String name){
//        Movie mov = new Movie();
        for (Movie m : movieList){
            if (m.getMovieName().equals(name)){
//                mov = m;
                return m;
            }
        }

        return null;
    }

    public Director getDirector(String name){
        for (Director d : directorList){
            if (d.getDirectorName().equals(name)){
                return d;
            }
        }

        return null;
    }

    public List<Movie> getMovieListViaDirector(String name){
        return movieRepository.getMovieListViaDirector(name);
    }

    public List<Movie> getMovieList(){
        return movieList;
    }

    public String deleteMoviesViaDirectorName(String name){
        List<Movie> movieList1 = movieRepository.deleteMoviesViaDirector(name);
        for (Movie m : movieList1){
            movieList.remove(m);
        }

        return "Success";
    }

    public String deleteAllDirectors(){
        List<Movie> l = movieRepository.deleteAllRecords();
        for (int i=0;i<l.size();i++){
            movieList.remove(l.get(i));
        }
//        for (Movie m : l){
//            movieList.remove(m);
//        }

        directorList.clear();
        return "Success";
    }
}