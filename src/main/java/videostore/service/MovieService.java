package videostore.service;

import videostore.model.Movie;

import java.util.List;

/**
 * Created by victor on 17/06/17.
 */
public interface MovieService {

    List<Movie> getMovies();

    Movie detail (String movieTitle);

    void newMovie (Movie movie);

    void modifyMovie (Movie movie);

    void deleteMovie (Integer movieId);

}