package org.sv.movie.service;

import org.springframework.data.domain.Sort;
import org.sv.movie.entity.Movie;
import org.sv.movie.entity.Response.MovieResponse;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAll();
    Optional<Movie> findByTitle(String title);
    List<Movie> findByFieldSort(Sort sort);

    List<Movie> findByTitleLike(String title);
    List<MovieResponse> findByTitleOrId(String title, long id);
    Movie saveMovie(Movie movie);
}
