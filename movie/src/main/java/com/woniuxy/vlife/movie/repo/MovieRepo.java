package com.woniuxy.vlife.movie.repo;

import com.woniuxy.vlife.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Integer> {
}
