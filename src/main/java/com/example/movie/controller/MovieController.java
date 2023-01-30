package com.example.movie.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.movie.controller.request.MovieRequest;
import com.example.movie.persistence.entity.Movie;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("app/v0.1/movie")
public class MovieController {

    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<Movie> getAllMovies() {
        return service.getAllMovie();
    }

    @GetMapping("/get/{id}")
    public Optional<Movie> getMovie(@PathVariable Long id) {
        System.out.println("id :"+id);
        return service.getMovie(id);
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody MovieRequest request) {
        service.addMovie(request);
    }

    @PatchMapping("/update")
    public void updateMovie(@RequestBody MovieRequest request) {
        service.updateMovie(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
    }

}
