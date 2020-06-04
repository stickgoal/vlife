package com.woniuxy.vlife.review.controller;

import com.woniuxy.vlife.review.entity.Review;
import com.woniuxy.vlife.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(produces = "application/json")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping("getReviewsByMovieId")
    public List<Review> getReviewsByMovieId(int movieId){
        log.info("查询电影评论：{}",movieId);
        return reviewService.getReviews(movieId);
    }

}
