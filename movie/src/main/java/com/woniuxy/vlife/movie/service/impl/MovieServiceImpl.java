package com.woniuxy.vlife.movie.service.impl;

import com.woniuxy.vlife.movie.client.ReviewClient;
import com.woniuxy.vlife.movie.entity.Movie;
import com.woniuxy.vlife.movie.entity.Review;
import com.woniuxy.vlife.movie.repo.MovieRepo;
import com.woniuxy.vlife.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ReviewClient reviewClient;

    @Override
    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Movie getDetail(int movieId) {
        Optional<Movie> optionalMovie = movieRepo.findById(movieId);
        if(optionalMovie.isPresent()){
            Movie movie = optionalMovie.get();
            List<Review> reviews = reviewClient.getReviewsByMovieId(movie.getMovieId());
            movie.setReviews(reviews);
            return movie;
        }
        return null;
    }
}
