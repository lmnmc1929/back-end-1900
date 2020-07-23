package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.*;
import phim.itsol.dto.MovieDto;
import phim.itsol.repo.GenreRepository;
import phim.itsol.repo.MovieImageRepository;
import phim.itsol.repo.MovieRepository;
import phim.itsol.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MovieServiceImpl implements MovieService {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final MovieImageRepository movieImageRepository;
    private final ModelMapper modelMapper;
    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository, MovieImageRepository movieImageRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.movieImageRepository = movieImageRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Movie getMovieByName(String movieName) {
        log.trace("Service to get movie by name = {}", movieName);
//        Optional<Movie> movieOptional = Optional.ofNullable(movieRepository.findMovieByMovieName(movieName));
//        return movieOptional
//                .map(movie->modelMapper.map(movie, MovieDto.class))
//                .orElse(null);
        return movieRepository.findMovieByMovieName(movieName);
    }

    @Override
    public List<Movie> getAllMovie() {
        log.trace("Service to get all Movie");
        List<Movie> movies = movieRepository.findAll();
//        return movies.stream()
//                .map(movie -> modelMapper.map(movie, MovieDto.class))
//                .collect(Collectors.toList());

        return movies;
    }

    @Override
    public List<Movie> getAllMoviesByName(String movieName) {
        log.trace("Service to get all Movie");
        List<Movie> movies = movieRepository.findMoviesByMovieNameContains(movieName);
        return movies;
    }

    @Override
    public Movie getMovieById(Long movieId) {
        log.trace("Service to get movie by id = {}", movieId);
        return movieRepository.findMovieByMovieId(movieId);
    }

    @Override
    public void create(MovieDto movieDto) {
        log.trace("Service to create Seat: {}", movieDto);


//        Room room = new Room();
//        room.setRoomId(seatDto.getRoomId());
//        seat.setRoom(room);
        List<Genre> genreList = new ArrayList<>();
        for (String genreId: movieDto.getGenreIds()) {
            genreList.add(genreRepository.findGenreByGenreId(Long.parseLong(genreId)));
        }
        movieDto.setGenreList(genreList);
        Movie movie = modelMapper.map(movieDto, Movie.class);
        movieRepository.save(movie);
        for (String movieImageUrl: movieDto.getMovieImageUrls()) {
//            movieImageList.add(movieImageRepository.findMovieImageByMovieImageId(Long.parseLong(movieImageId)));
            MovieImage movieImage = new MovieImage(null,movieImageUrl,movie);
            movieImageRepository.save(movieImage);
        }
//        movieDto.setMovieImageList(movieImageList);
    }

    @Override
    public void update(MovieDto movieDto) {
        log.trace("Service to update Seat: {}", movieDto);
        Movie movie = movieRepository.getOne(movieDto.getMovieId());
        movie.setMovieName(movieDto.getMovieName());
        movie.setMovieYear(movieDto.getMovieYear());
        movie.setMovieDuration(movieDto.getMovieDuration());
        movie.setDescription(movieDto.getDescription());
        List<Genre> genreList = new ArrayList<>();
        List<MovieImage> movieImageList = new ArrayList<>();
        for (String genreId: movieDto.getGenreIds()) {
            genreList.add(genreRepository.findGenreByGenreId(Long.parseLong(genreId)));
        }
        movie.setGenreList(genreList);
        movieRepository.save(movie);
        movieImageRepository.deleteAllByMovie_MovieId(movieDto.getMovieId());
        for (String movieImageUrl: movieDto.getMovieImageUrls()) {
//            movieImageList.add(movieImage);
            MovieImage movieImage = new MovieImage(null,movieImageUrl,movie);
            movieImageRepository.save(movieImage);
        }
    }

    @Override
    public void delete(Long movieId) {
            movieRepository.deleteById(movieId);
//        movieImageRepository.deleteAllByMovie_MovieId(movieId);
    }
}
