package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Cinema;
import phim.itsol.domain.Movie;
import phim.itsol.domain.Room;
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
        log.trace("Service to create movie {}", movieDto);
        Movie movie = modelMapper.map(movieDto, Movie.class);
        movieRepository.save(movie);
    }

    @Override
    public void update(MovieDto movieDto) {
        log.trace("Service to update Movie: {}", movieDto);
        Movie movieDb = movieRepository.getOne(movieDto.getMovieId());

        movieDb.setMovieName(movieDto.getMovieName());
        movieDb.setMovieDate(movieDto.getMovieDate());
        movieDb.setMovieDuration(movieDto.getDuration());
        movieDb.setDescription(movieDto.getDescription());
        movieDb.setMovieImageList(movieDto.getMovieImageID());
        movieDb.setGenreList(movieDto.getGenreList());

        movieRepository.save(movieDb);
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
