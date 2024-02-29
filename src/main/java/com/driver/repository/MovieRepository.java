package com.driver.repository;

import com.driver.Director;
import com.driver.model.DirectorMoviePair;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    static HashMap<Movie, Director> map = new HashMap<>();

//    static {
//        map.put(new Movie("Avengers"), new Director("Mahatma Gandhi"));
//        map.put(new Movie("Aven"), new Director("Mahatma"));
//        map.put(new Movie("A"), new Director("Maha"));
//    }
    public String pairDirectorMovie(List<Movie> movieList, List<Director> directorList, String movieName,
                                    String directorName){
        Movie m1 = null;
        Director d1 = null;
        for (Movie m : movieList){
            if (m.getName().equals(movieName)){
                m1 = m;
            }
        }

        for (Director d : directorList){
            if (d.getName().equals(directorName)){
                d1 = d;
            }
        }

        if (m1 != null && d1 != null){
            map.put(m1, d1);
        }

        return "Success";
    }

    public List<Movie> getMovieListViaDirector(String name){
        List<Movie> ans = new ArrayList<>();
        for (Movie m : map.keySet()){
            if (map.get(m).getName().equals(name)){
                ans.add(m);
            }
        }

        return ans;
    }

    public List<Movie> deleteMoviesViaDirector(String name){
        List<Movie> movieList = new ArrayList<>();
        for (Movie m : map.keySet()){
            System.out.println(map.get(m).getName());
            if (map.get(m).getName().equals(name)){
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
