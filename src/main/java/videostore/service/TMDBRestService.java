package videostore.service;

import videostore.model.Movie;

/**
 * Created by victor on 2/07/17.
 */
public interface TMDBRestService {

    Movie getMovieInfo(Movie movie);

    String getMovieDesc(String movieTitle);

    Integer getMovieYear(String movieTitle);

    String getMovieDirector(String movieTitle);

    String getMovieActors(String movieTitle);

    String getMovieUrlFront(String movieTitle);

    Double getMovieRating(String movieTitle);

}
