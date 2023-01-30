package com.example.movie.service;

import com.example.movie.controller.request.MovieRequest;
import com.example.movie.persistence.MoviePersistence;
import com.example.movie.persistence.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MoviePersistence persistence;

    @Autowired
    public MovieService(MoviePersistence persistence) {
        this.persistence = persistence;
    }

    public List<Movie> getAllMovie() {
        return persistence.getAllMovies();
    }

    public Optional<Movie> getMovie(Long id) {
        return persistence.getMovie(id);
    }

    public void addMovie(MovieRequest request) {
        persistence.addMovie(request);
    }

    public void updateMovie(MovieRequest request) {
        persistence.update(request);
    }

    public void deleteMovie(Long id) {
        persistence.delete(id);
    }
}
