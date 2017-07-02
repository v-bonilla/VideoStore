package videostore.service;

import videostore.model.Movie;

import java.util.List;

/**
 * Created by victor on 17/06/17.
 */
public interface MovieService {

    List<Movie> getMovies();

    Movie search (String movieTitle);

    Movie watch (Integer movieId);

    Movie detail (Integer movieId);

    Movie newMovie (Movie movie);

    Movie modifyMovie (Movie movie);

    void deleteMovie (Integer movieId);

}