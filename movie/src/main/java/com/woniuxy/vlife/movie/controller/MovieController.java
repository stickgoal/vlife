package com.woniuxy.vlife.movie.controller;

import com.woniuxy.vlife.movie.entity.Movie;
import com.woniuxy.vlife.movie.entity.Review;
import com.woniuxy.vlife.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(produces = "application/json")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "movies")
    @ResponseBody
    public List<Movie> getAllMovies(){
        return movieService.getMovies();
    }

    @RequestMapping(value="detail")
    @ResponseBody
    public Movie getDetail(int movieId){
        return movieService.getDetail(movieId);
    }


}
