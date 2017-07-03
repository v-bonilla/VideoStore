package videostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import videostore.model.Movie;
import videostore.repository.MovieRepository;
import videostore.service.MovieService;
import videostore.service.TMDBRestService;

import java.util.List;

/**
 * Created by victor on 17/06/17.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private TMDBRestService tmdbRestService;

    @Override
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @Override
    public Movie search(String movieTitle) {

        return repository.findByMovieTitleIsLike(movieTitle);
    }

    @Override
    public Movie watch(Integer movieId) {
        // TODO Auto-generated method stub
        return repository.findOne(movieId);
    }

    @Override
    public Movie detail(Integer movieId) {
        // TODO Auto-generated method stub
        return repository.findOne(movieId);
    }

    @Override
    public void newMovie(Movie movie) {
        if (repository.findByMovieTitleIsLike(movie.getMovieTitle()) == null){
            if (movie.getMovieDesc().equals("")) {
                movie.setMovieDesc(tmdbRestService.getMovieDesc(movie.getMovieTitle()));
            }
            if (movie.getMovieYear() == -1) {
                movie.setMovieYear(tmdbRestService.getMovieYear(movie.getMovieTitle()));
            }
            if (movie.getMovieDirector().equals("")) {
                movie.setMovieDirector(tmdbRestService.getMovieDirector(movie.getMovieTitle()));
            }
            if (movie.getMovieActors().equals("")) {
                movie.setMovieActors(tmdbRestService.getMovieActors(movie.getMovieTitle()));
            }
            if (movie.getMovieUrlFront().equals("")) {
                movie.setMovieUrlFront(tmdbRestService.getMovieUrlFront(movie.getMovieTitle()));
            }
            if (movie.getMovieRating() == -1.0) {
                movie.setMovieRating(tmdbRestService.getMovieRating(movie.getMovieTitle()));
            }
            repository.save(movie);
        }
    }

    @Override
    public void modifyMovie(Movie movie) {
        //TODO: si cambia titulo llamar a API
        Movie actualMovie = repository.findByMovieId(movie.getMovieId());
        if (actualMovie != null){
            if (movie.getMovieTitle().equals("")){
                movie.setMovieTitle(actualMovie.getMovieTitle());
            }
            if (movie.getMovieUrl().equals("")){
                movie.setMovieUrl(actualMovie.getMovieUrl());
            }
            if (movie.getMovieDesc().equals("")){
                movie.setMovieDesc(actualMovie.getMovieDesc());
            }
            if (movie.getMovieYear() == -1){
                movie.setMovieYear(actualMovie.getMovieYear());
            }
            if (movie.getMovieDirector().equals("")){
                movie.setMovieDirector(actualMovie.getMovieDirector());
            }
            if (movie.getMovieActors().equals("")){
                movie.setMovieActors(actualMovie.getMovieActors());
            }
            if (movie.getMovieUrlFront().equals("")){
                movie.setMovieUrlFront(actualMovie.getMovieUrlFront());
            }
            if (movie.getMovieRating() == -1.0){
                movie.setMovieRating(actualMovie.getMovieRating());
            }
            repository.save(movie);
        }
    }

    @Override
    public void deleteMovie(Integer movieId) {
        Movie actualMovie = repository.findByMovieId(movieId);
        if (actualMovie != null){
            repository.delete(actualMovie);
        }
    }


}