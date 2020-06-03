package com.woniuxy.vlife.movie.entity;

import lombok.Data;

import java.util.List;

@Data
public class Movie {

    private int movieId;
    //海报图片
    private String posterUrl;
    //电影名称
    private String  movieName;

    private String shortDescription;
    //电影描述
    private String description;
    //电影评分
    private double score;
    //演员
   private Man[] actors;
    //导演
    private Man director;
    //评论
    private List<Review> reviews;

    public Movie() {
    }

    public Movie(int movieId, String posterUrl, String movieName, String description) {
        this.movieId = movieId;
        this.posterUrl = posterUrl;
        this.movieName = movieName;
        this.description = description;
        this.shortDescription = description!=null&&description.length()>50?description.substring(0,50)+"...":description;
    }
}
