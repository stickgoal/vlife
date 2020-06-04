package com.woniuxy.vlife.review.service.impl;

import com.woniuxy.vlife.review.entity.Review;
import com.woniuxy.vlife.review.repo.ReviewRepo;
import com.woniuxy.vlife.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public List<Review> getReviews(int movieId) {
        return reviewRepo.findReviewByMovieId(movieId);
    }
}
