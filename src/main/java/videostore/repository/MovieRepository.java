package videostore.repository;

import org.springframework.data.repository.CrudRepository;
import videostore.model.Movie;

/**
 * Created by victor on 9/06/17.
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findByTitle(String movie_title);
}
