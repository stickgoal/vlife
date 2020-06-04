package com.woniuxy.vlife.movie.client;

import com.woniuxy.vlife.movie.entity.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("review")
public interface ReviewClient {

    @RequestMapping("getReviewsByMovieId")
    List<Review> getReviewsByMovieId(@RequestParam int movieId);

}
