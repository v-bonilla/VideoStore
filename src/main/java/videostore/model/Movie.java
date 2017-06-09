package videostore.model;

import javax.persistence.*;

/**
 * Created by victor on 9/06/17.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movie_id;
    @Column(unique=true)
    private String movie_title;
    private String movie_url;
    private String movie_desc;
    private int movie_year;
    private String movie_director;
    private String movie_actors;
    private String movie_url_front;
    private double movie_rating;

    public Movie() {}

    public Movie(String movie_title, String movie_url, String movie_desc, int movie_year, String movie_director, String movie_actors, String movie_url_front, double movie_rating) {
        this.movie_title = movie_title;
        this.movie_url = movie_url;
        this.movie_desc = movie_desc;
        this.movie_year = movie_year;
        this.movie_director = movie_director;
        this.movie_actors = movie_actors;
        this.movie_url_front = movie_url_front;
        this.movie_rating = movie_rating;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_url() {
        return movie_url;
    }

    public void setMovie_url(String movie_url) {
        this.movie_url = movie_url;
    }

    public String getMovie_desc() {
        return movie_desc;
    }

    public void setMovie_desc(String movie_desc) {
        this.movie_desc = movie_desc;
    }

    public int getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(int movie_year) {
        this.movie_year = movie_year;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_actors() {
        return movie_actors;
    }

    public void setMovie_actors(String movie_actors) {
        this.movie_actors = movie_actors;
    }

    public String getMovie_url_front() {
        return movie_url_front;
    }

    public void setMovie_url_front(String movie_url_front) {
        this.movie_url_front = movie_url_front;
    }

    public double getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(double movie_rating) {
        this.movie_rating = movie_rating;
    }
}
