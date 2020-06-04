package com.woniuxy.vlife.movie.service;

import com.woniuxy.vlife.movie.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMovies();

    Movie getDetail(int movieId);
}
