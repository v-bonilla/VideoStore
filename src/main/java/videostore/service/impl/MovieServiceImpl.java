package videostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import videostore.model.Movie;
import videostore.repository.MovieRepository;
import videostore.service.MovieService;

import java.util.List;

/**
 * Created by victor on 17/06/17.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repo;

    @Override
    public List<Movie> getMovies() {

        return null;
    }

    @Override
    public Movie search(String movieTitle) {

        return repo.findByMovieTitleIsLike(movieTitle);
    }

    @Override
    public Movie watch(Integer movieId) {
        // TODO Auto-generated method stub
        return repo.findOne(movieId);
    }

    @Override
    public Movie detail(Integer movieId) {
        // TODO Auto-generated method stub
        return repo.findOne(movieId);
    }

    @Override
    public Movie newMovie(Movie movie) {
        // TODO Auto-generated method stub
        return repo.save(movie);
    }

    @Override
    public Movie modifyMovie(Movie movie) {
        // TODO Auto-generated method stub
        return repo.save(movie);
    }

    @Override
    public void deleteMovie(Integer movieId) {
        // TODO Auto-generated method stub
        repo.delete(movieId);
    }


}