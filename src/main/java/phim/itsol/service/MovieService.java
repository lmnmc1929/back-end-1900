package phim.itsol.service;

import phim.itsol.domain.Genre;
import phim.itsol.domain.Movie;
import phim.itsol.domain.MovieImage;
import phim.itsol.dto.MovieDto;
import phim.itsol.dto.SeatDto;

import java.util.List;

public interface MovieService {
    /**
     * Get one movie
     * @param movieName
     * @return
     */
    Movie getMovieByName(String movieName);
    /**
     * Get all movie
     *
     * @return
     */
    List<Movie> getAllMovie();
    /**
     * Get all movie
     *
     * @return
     */
    List<Movie> getAllMoviesByName(String movieName);
    /**
     * Get one movie
     * @param movieId
     * @return
     */
    Movie getMovieById(Long movieId);
    /**
     * create seat
     *
     * @param movieDto
     */

    void create(MovieDto movieDto);

    /**
     * update movie
     *
     * @param movieDto
     */
    void update(MovieDto movieDto);

    /**
     *
     * @param movieId
     */
    void delete(Long movieId);
}
