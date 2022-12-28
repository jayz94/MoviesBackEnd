package org.sv.movie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sv.movie.dao.MovieRepository;
import org.sv.movie.entity.Movie;
import org.sv.movie.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MovieServiceTest {

    @Mock//add the repo
    private MovieRepository movieRepo;

    @InjectMocks//add the class to test
    private MovieServiceImpl movieService;

    private List<Movie> movies = new ArrayList<Movie>()
    {
        {
            add(new Movie(10, "Xmen", new User(), false));
        }
    };
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {
        when(movieRepo.findAll()).thenReturn(movies);
        //assert
        assertNotNull(movieService.findAll());
    }

    @Test
    void findByTitle() {
    }
}