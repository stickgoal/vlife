package com.woniuxy.vlife.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private int reviewId;

    private String content;

    private int userId;

    private String username;

    private Date publishDate;



}
