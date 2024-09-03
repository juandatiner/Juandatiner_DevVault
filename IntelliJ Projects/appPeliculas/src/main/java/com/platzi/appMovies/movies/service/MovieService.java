package com.platzi.appMovies.movies.service;

import com.platzi.appMovies.movies.data.MovieRepository;
import com.platzi.appMovies.movies.model.Genre;
import com.platzi.appMovies.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream().
                filter(movie -> movie.getGenre().equals(genre)).
                collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDuration(int duration) {

        return movieRepository.findAll().stream().
                filter(movie -> movie.getMinutes() <= duration).
                collect(Collectors.toList());
    }
}
