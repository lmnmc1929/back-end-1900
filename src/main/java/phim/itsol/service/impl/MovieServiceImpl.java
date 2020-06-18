package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Movie;
import phim.itsol.domain.MovieImage;
import phim.itsol.dto.MovieDto;
import phim.itsol.repo.MovieRepository;
import phim.itsol.service.MovieService;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)

public class MovieServiceImpl implements MovieService {
    private Logger log = LoggerFactory.getLogger(getClass());
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;
    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Movie> getAllMovies() {
        log.trace("Service to get all Room");
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @Override
    public void create(MovieDto movieDto) {
        log.trace("Service to create movie: {}", movieDto);
        Movie movie = modelMapper.map(movieDto, Movie.class);

        MovieImage movieImage = new MovieImage();
        movieImage.setMovieImageId(movie.getMovieId());
        movie.setMovieImageList((List<MovieImage>) movieDto);


        movieRepository.save(movie);
    }

    @Override
    public void update(MovieDto movieDto) {
        log.trace("Service to update movie: {}", movieDto);
        Movie movie = movieRepository.getOne(movieDto.getMovieId());

        movie.setMovieName(movie.getMovieName());
        movie.setMovieYear(movie.getMovieYear());
        movie.setMovieDuration(movie.getMovieDuration());
        movie.setDescription(movie.getDescription());

        MovieImage movieImage = new MovieImage();
        movieImage.setMovieImageId(movieDto.getMovieId());
        movie.setMovieImageList((List<MovieImage>) movieImage);

        movieRepository.save(movie);
    }


    @Override
    public void delete(Long movieId) {
        movieRepository.deleteById(movieId);
    }



    @Override
    public Movie getMovie(Long movieId) {

        return movieRepository.getOne(movieId);
    }
}
