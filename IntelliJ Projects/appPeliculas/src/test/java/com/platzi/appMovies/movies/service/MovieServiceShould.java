package com.platzi.appMovies.movies.service;

import com.platzi.appMovies.movies.data.MovieRepository;
import com.platzi.appMovies.movies.model.Genre;
import com.platzi.appMovies.movies.model.Movie;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(            //When ask for findAll movies gives these movies
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION),
                        new Movie(8, "GhostBusters", 160, Genre.THRILLER),
                        new Movie(9, "MythBusters", 151, Genre.THRILLER),
                        new Movie(10, "DemonBusters", 195, Genre.THRILLER)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie>  movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
        //is es un matcher that check that

        //Verify that's correct if movieIds 3 and 6 are comedy movies
    }

    @Test
    public void return_movies_by_duration() {

        Collection<Movie>  movies = movieService.findMoviesByDuration(119);

//        List<Integer> movieIds = getMovieIds(movies);
//        assertThat(movieIds , is(Arrays.asList(2, 3, 4, 5, 6)));

        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
        //is is un matcher that check that
        //Verify that's correct if movieIds 3 and 6 are comedy movies
    }

    private static List<Integer> getMovieIds(Collection<Movie> movies) {    //is a method that used in a lot of parts
//                                                  movie -> movie.getId()
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
        //stream is a sequence of elements
        //map applies the function movie -> movie.getId
        //collect convert the sequence in a list

//        List<Integer> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
//        return movieIds;
    }
}