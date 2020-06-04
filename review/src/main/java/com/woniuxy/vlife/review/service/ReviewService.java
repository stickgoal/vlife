package com.woniuxy.vlife.review.service;

import com.woniuxy.vlife.review.entity.Review;

import java.util.List;

public interface ReviewService {

    public List<Review> getReviews(int movieId);

}
