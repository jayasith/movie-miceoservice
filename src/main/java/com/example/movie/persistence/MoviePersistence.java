package com.example.movie.persistence;

import com.example.movie.controller.request.MovieRequest;
import com.example.movie.persistence.entity.Category;
import com.example.movie.persistence.entity.Movie;
import com.example.movie.persistence.repository.CategoryRepository;
import com.example.movie.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MoviePersistence {

    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MoviePersistence(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(Long id) {
        return movieRepository.findById(id);
    }

    public void addMovie(MovieRequest request) {
        Optional<Category> categories = categoryRepository.findById(request.getCategoryId());
        Category category;
        category = categories.orElseGet(() -> Category.builder()
                .name(request.getName())
                .build());

        Movie movie = Movie.builder()
                .name(request.getName())
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .category(category)
                .build();
        movieRepository.save(movie);
    }

    public void update(MovieRequest request) {
        Optional<Movie> movie = movieRepository.findByName(request.getName());
        Optional<Category> category = categoryRepository.findById(request.getCategoryId());

        Movie updatedMovie = Movie.builder()
                .id(movie.get().getId())
                .name(request.getName())
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .category(category.get())
                .build();
        movieRepository.save(updatedMovie);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
