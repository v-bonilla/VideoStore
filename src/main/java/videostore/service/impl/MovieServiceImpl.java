package videostore.service.impl;

import videostore.service.MovieService;

/**
 * Created by victor on 17/06/17.
 */
public class MovieServiceImpl implements MovieService {

    @Override
    public String search(String movie_title) {
        return null;
    }

    @Override
    public String watch(int movie_id) {
        return null;
    }

    @Override
    public String newMovie(String movie_title, String movie_url, String movie_desc, int movie_year, String movie_director, String movie_actors, String movie_url_front, double movie_rating) {
        return null;
    }

    @Override
    public String modifyMovie(int movie_id, String movie_title, String movie_url, String movie_desc, int movie_year, String movie_director, String movie_actors, String movie_url_front, double movie_rating) {
        return null;
    }

    @Override
    public String deleteMovie(int movie_id) {
        return null;
    }

}
