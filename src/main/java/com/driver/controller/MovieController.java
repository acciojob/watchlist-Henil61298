package com.driver.controller;

import com.driver.model.Director;
import com.driver.model.DirectorMoviePair;
import com.driver.model.Movie;
import com.driver.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService = new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie m){
        movieService.addMovie(m);
        return new ResponseEntity<>("Movie added successfully!", HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public String add(){
////        System.out.println(m.getMovieName());
//        return "Working";
//    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director d){
        movieService.addDirector(d);
        return new ResponseEntity<>("Director added successfully!", HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addPair(@RequestBody DirectorMoviePair dm){
        movieService.addPair(dm);
        return new ResponseEntity<>("Director Movie Pair added successfully!", HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
//        return new ResponseEntity<>(movieService.getMovie(name), HttpStatus.OK);
        return new ResponseEntity<>(movieService.getMovie(name), HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
//        return new ResponseEntity<>(movieService.getMovie(name), HttpStatus.OK);
        return new ResponseEntity<>(movieService.getDirector(name), HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirector(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieListViaDirector(name), HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity getMovieList(){
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirector(@RequestBody Director d){
        return new ResponseEntity<>(movieService.deleteMoviesViaDirectorName(d), HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }

    @GetMapping("/hello/{name}")
    public String printName(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/get-movies")
    public String getSomething(){
        return "Hello there!";
    }

    @GetMapping("/get-movie")
    public ResponseEntity getMovie(@RequestParam("movieName") String name){
        return new ResponseEntity(movieService.getMovie(name), HttpStatus.OK);
    }
}
