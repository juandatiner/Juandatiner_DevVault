package com.platzi.appMovies.movies.data;

import com.platzi.appMovies.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    Collection<Movie> findByName(String name);

    void saveOrUpdate(Movie movie);

}
