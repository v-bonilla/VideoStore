package videostore.service;

/**
 * Created by victor on 17/06/17.
 */
public interface MovieService {

    String search (String movie_title);

    String watch (int movie_id);

    String newMovie (String movie_title,
                     String movie_url,
                     String movie_desc,
                     int movie_year,
                     String movie_director,
                     String movie_actors,
                     String movie_url_front,
                     double movie_rating);

    String modifyMovie (int movie_id,
                        String movie_title,
                        String movie_url,
                        String movie_desc,
                        int movie_year,
                        String movie_director,
                        String movie_actors,
                        String movie_url_front,
                        double movie_rating);

    String deleteMovie (int movie_id);

}
