package com.woniuxy.vlife.movie.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "vlife_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int movieId;
    //海报图片
    private String posterUrl;
    //电影名称
    private String  movieName;

    private String shortDescription;
    //电影描述
    @Length(max=2048)
    private String description;
    //电影评分
    private double score;
    //演员
   private String actors;
    //导演
    private String director;

    //评论
    @Transient
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
