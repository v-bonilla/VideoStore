package videostore.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Created by victor on 9/06/17.
 */
@Entity
public class Movie implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movie_id")
    private Integer movieId;

    @Column(name="movie_title",unique=true)
    private String movieTitle;
    @Column(name="movie_url")
    private String movieUrl;
    @Column(name="movie_desc", length = 5000)
    private String movieDesc;
    @Column(name="movie_year")
    private Integer movieYear;
    @Column(name="movie_director")
    private String movieDirector;
    @Column(name="movie_actors", length = 5000)
    private String movieActors;
    @Column(name="movie_url_front")
    private String movieUrlFront;
    @Column(name="movie_rating")
    private Double movieRating;

    public Movie() {}

    public Movie(String movieTitle, String movieUrl, String movieDesc, Integer movieYear, String movieDirector,
                 String movieActors, String movieUrlFront, Double movieRating) {
        super();
        this.movieTitle = movieTitle;
        this.movieUrl = movieUrl;
        this.movieDesc = movieDesc;
        this.movieYear = movieYear;
        this.movieDirector = movieDirector;
        this.movieActors = movieActors;
        this.movieUrlFront = movieUrlFront;
        this.movieRating = movieRating;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public Integer getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public String getMovieUrlFront() {
        return movieUrlFront;
    }

    public void setMovieUrlFront(String movieUrlFront) {
        this.movieUrlFront = movieUrlFront;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(Double movieRating) {
        this.movieRating = movieRating;
    }


}