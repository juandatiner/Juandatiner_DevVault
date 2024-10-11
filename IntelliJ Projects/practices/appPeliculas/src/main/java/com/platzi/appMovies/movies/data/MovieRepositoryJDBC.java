package com.platzi.appMovies.movies.data;

import com.platzi.appMovies.movies.model.Genre;
import com.platzi.appMovies.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;


import java.util.Collection;


public class MovieRepositoryJDBC implements MovieRepository {

    final private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Movie findById(long id) {

        Object[] args = { id };

        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper); //queryForObject gets one

    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies", movieMapper);  //query gets a list
    }

    @Override
    public Collection<Movie> findByName(String name) {

        name = name.toLowerCase();
        return jdbcTemplate.query("select * from movies where lower(name) LIKE '%" + name + "%'", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        jdbcTemplate.update("insert into movies (name, minutes, genre) values (?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());

    }

    final private static RowMapper<Movie> movieMapper = (rs, rowNum) -> {

        return new Movie(
                rs.getInt("id"),  // is the name in the database
                rs.getString("name"),
                rs.getInt("minutes"),
                Genre.valueOf(rs.getString("genre")));  //Genre cause is an enum
    };


}
