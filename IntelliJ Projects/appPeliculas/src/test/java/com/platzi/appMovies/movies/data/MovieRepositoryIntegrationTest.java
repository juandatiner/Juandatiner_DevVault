package com.platzi.appMovies.movies.data;

import com.platzi.appMovies.movies.model.Genre;
import com.platzi.appMovies.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJDBC movieRepositoryJDBC;
    private DataSource dataSource;


    @Before
    public void setUp() throws Exception {
        // Create an in-memory data source for the test database
        dataSource = new DriverManagerDataSource(
                "jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        // Execute the SQL script to set up the database
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/data.sql"));

        // Initialize JdbcTemplate with the data source
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Create an instance of MovieRepositoryJDBC with JdbcTemplate
        movieRepositoryJDBC = new MovieRepositoryJDBC(jdbcTemplate);

    }

    @Test
    public void load_all_movies() {

        // Retrieve movies from the database
        Collection<Movie> movies = movieRepositoryJDBC.findAll();

        // Verify that the movies are as expected
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @Test
    public void load_movie_by_id() {

        Movie movie = movieRepositoryJDBC.findById(2);

        assertThat( movie, is(new Movie(2, "Memento", 113, Genre.THRILLER)));

    }

    @Test
    public void find_movie_by_name() {

        Collection<Movie> movies = movieRepositoryJDBC.findByName("Dark");
        assertThat(movies, is(Collections.singletonList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION)
        )));
    }

    @Test
    public void insert_a_movie() {

        Movie movie = new Movie("Super 8", 112, Genre.THRILLER); // characteristics movie

        movieRepositoryJDBC.saveOrUpdate(movie); // add movie

        Movie movieFromDb = movieRepositoryJDBC.findById(4); // get the id of the new movie

        assertThat( movieFromDb, is(new Movie(4, "Super 8", 112, Genre.THRILLER)));  // verify if the movie added correctly

    }

    @After // execute after each test
    public void tearDown() throws Exception {

        // remove H2 files -- https://stackoverflow.com/a/51809831/1121497

        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}