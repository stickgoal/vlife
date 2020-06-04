package com.woniuxy.vlife.review.repo;

import com.woniuxy.vlife.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review,Integer> {

    List<Review> findReviewByMovieId(int movieId);


}
