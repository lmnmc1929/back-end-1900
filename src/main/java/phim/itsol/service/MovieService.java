package phim.itsol.service;

import phim.itsol.domain.Movie;
import phim.itsol.dto.MovieDto;

import java.util.List;

public interface MovieService {
    /**
     * Get all movie
     *
     * @return
     */
    List<Movie> getAllMovies();

    /**
     * create movie
     *
     * @param movie
     */
    void create(MovieDto movie);

    /**
     * update movie
     *
     * @param movie
     */
    void update(MovieDto movie);

    /**
     *
     * @param movieId
     */
    void delete(Long movieId);

    /**
     * Get one movie
     * @param movieId
     * @return
     */

    Movie getMovie(Long movieId);
}
