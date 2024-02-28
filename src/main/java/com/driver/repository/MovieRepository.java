package com.driver.repository;

import com.driver.model.Director;
import com.driver.model.DirectorMoviePair;
import com.driver.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    static HashMap<Movie, Director> map = new HashMap<>();

    static {
        map.put(new Movie("Avengers"), new Director("Mahatma Gandhi"));
        map.put(new Movie("Aven"), new Director("Mahatma"));
        map.put(new Movie("A"), new Director("Maha"));
    }
    public String pairDirectorMovie(List<Movie> movieList, List<Director> directorList, DirectorMoviePair dm){
        String movieName = dm.getMovieName();
        String directorName = dm.getDirectorName();
        Movie movie1 = null;
        Director director1 = null;

        for (Movie m : movieList){
            if (m.getMovieName().equals(movieName)){
                movie1 = m;
            }
        }

        for (Director d : directorList){
            if (d.getDirectorName().equals(directorName)){
                director1 = d;
            }
        }

        if (movie1 != null && director1 != null){
            map.put(movie1, director1);
            return "Success";
        }

        return "Not success";
    }

    public List<Movie> getMovieListViaDirector(String name){
        List<Movie> ans = new ArrayList<>();
        for (Movie m : map.keySet()){
            if (map.get(m).getDirectorName().equals(name)){
                ans.add(m);
            }
        }

        return ans;
    }

    public List<Movie> deleteMoviesViaDirector(String name){
        List<Movie> movieList = new ArrayList<>();
        for (Movie m : map.keySet()){
            if (map.get(m).getDirectorName().equals(name)){
                movieList.add(m);
                map.remove(m);
            }
        }

        return movieList;
    }

    public List<Movie> deleteAllRecords(){
        List<Movie> ans = new ArrayList<>();
        for (Movie m : map.keySet()){
            ans.add(m);
            map.remove(m);
        }

        return ans;
    }
}
