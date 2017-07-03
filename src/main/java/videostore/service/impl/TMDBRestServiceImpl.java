package videostore.service.impl;

import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.PersonCast;
import org.springframework.stereotype.Service;
import videostore.model.Movie;
import videostore.service.TMDBRestService;
import info.movito.themoviedbapi.TmdbApi;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/**
 * Created by victor on 2/07/17.
 */
@Service
public class TMDBRestServiceImpl implements TMDBRestService {

    private TmdbApi tmdbApi = new TmdbApi("333162d886cfdcd3deb3b5dea6e31a06");
    private TmdbSearch searchApi = tmdbApi.getSearch();
    private TmdbMovies moviesApi = tmdbApi.getMovies();


    @Override
    public Movie getMovieInfo(Movie ourMovie){
        // Search movie
        MovieResultsPage movieResultsPage = searchApi.searchMovie(ourMovie.getMovieTitle(), null, null, false, null);
        if (movieResultsPage.getResults().size() > 0) {
            // Search complete info of movie
            MovieDb movieDb = moviesApi.getMovie(movieResultsPage.getResults().get(0).getId(), "es", new TmdbMovies.MovieMethod[]{TmdbMovies.MovieMethod.credits});
            // Copy info to our movie object
            ourMovie.setMovieDesc(movieDb.getOverview());
            ourMovie.setMovieYear(Integer.valueOf(movieDb.getReleaseDate().substring(0, 4)));
            ourMovie.setMovieDirector(movieDb.getCredits().getCrew().get(0).getName());
            ourMovie.setMovieActors(castToString(movieDb.getCredits().getCast()));
            ourMovie.setMovieUrlFront(tmdbApi.getConfiguration().getSecureBaseUrl() + tmdbApi.getConfiguration().getPosterSizes().get(2) + movieDb.getPosterPath());
            // Formatea el double con DecimalFormat y parsea a double porque DecimalFormat devuelve un string
            ourMovie.setMovieRating(Double.parseDouble(new DecimalFormat("#.##").format((double) movieDb.getVoteAverage())));
        }
        return ourMovie;
    }

    @Override
    public String getMovieDesc(String movieTitle) {
        // Search movie
        MovieResultsPage movieResultsPage = searchApi.searchMovie(movieTitle, null, null, false, null);
        String res = "";
        if (movieResultsPage.getResults().size() > 0) {
            // Search complete info of movie
            MovieDb movieDb = moviesApi.getMovie(movieResultsPage.getResults().get(0).getId(), "es", new TmdbMovies.MovieMethod[]{TmdbMovies.MovieMethod.credits});
            res = movieDb.getOverview();
        }
        return res;
    }

    @Override
    public Integer getMovieYear(String movieTitle) {
        // Search movie
        MovieResultsPage movieResultsPage = searchApi.searchMovie(movieTitle, null, null, false, null);
        int res = -1;
        if (movieResultsPage.getResults().size() > 0) {
            // Search complete info of movie
            MovieDb movieDb = moviesApi.getMovie(movieResultsPage.getResults().get(0).getId(), "es", new TmdbMovies.MovieMethod[]{TmdbMovies.MovieMethod.credits});
            res = Integer.valueOf(movieDb.getReleaseDate().substring(0,4));
        }
        return res;
    }

    @Override
    public String getMovieDirector(String movieTitle) {
        // Search movie
        MovieResultsPage movieResultsPage = searchApi.searchMovie(movieTitle, null, null, false, null);
        String res = "";
        if (movieResultsPage.getResults().size() > 0) {
            // Search complete info of movie
            MovieDb movieDb = moviesApi.getMovie(movieResultsPage.getResults().get(0).getId(), "es", new TmdbMovies.MovieMethod[]{TmdbMovies.MovieMethod.credits});
            res = movieDb.getCredits().getCrew().get(0).getName();
        }
        return res;
    }

    @Override
    public String getMovieActors(String movieTitle) {
        // Search movie
        MovieResultsPage movieResultsPage = searchApi.searchMovie(movieTitle, null, null, false, null);
        String res = "";
        if (movieResultsPage.getResults().size() > 0) {
            // Search complete info of movie
            MovieDb movieDb = moviesApi.getMovie(movieResultsPage.getResults().get(0).getId(), "es", new TmdbMovies.MovieMethod[]{TmdbMovies.MovieMethod.credits});
            res = castToString(movieDb.getCredits().getCast());
        }
        return res;
    }

    @Override
    public String getMovieUrlFront(String movieTitle) {
        // Search movie
        MovieResultsPage movieResultsPage = searchApi.searchMovie(movieTitle, null, null, false, null);
        String urlFront = null;
        if (movieResultsPage.getResults().size() > 0) {
            // Search complete info of movie
            MovieDb movieDb = moviesApi.getMovie(movieResultsPage.getResults().get(0).getId(), "es", new TmdbMovies.MovieMethod[]{TmdbMovies.MovieMethod.credits});
            urlFront = tmdbApi.getConfiguration().getSecureBaseUrl() + tmdbApi.getConfiguration().getPosterSizes().get(2) + movieDb.getPosterPath();
        }
        return urlFront;
    }

    @Override
    public Double getMovieRating(String movieTitle) {
        // Search movie
        MovieResultsPage movieResultsPage = searchApi.searchMovie(movieTitle, null, null, false, null);
        double res = -1.0;
        if (movieResultsPage.getResults().size() > 0) {
            // Search complete info of movie
            MovieDb movieDb = moviesApi.getMovie(movieResultsPage.getResults().get(0).getId(), "es", new TmdbMovies.MovieMethod[]{TmdbMovies.MovieMethod.credits});
            // Formatea el double con DecimalFormat y parsea a double porque DecimalFormat devuelve un string
            res = Double.parseDouble(new DecimalFormat("#.##").format((double) movieDb.getVoteAverage()));
        }
        return res;
    }

    public String castToString(List<PersonCast> actorsArrayList){
        String res = "";
        Iterator<PersonCast> iterator = actorsArrayList.iterator();
        while (iterator.hasNext()){
            res += iterator.next().getName() + ", ";
        }
        // Quita la ultima coma
        return res.substring(0, res.lastIndexOf(","));
    }

}
