package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.domain.Movie;
import phim.itsol.dto.MovieDto;
import phim.itsol.dto.SeatDto;
import phim.itsol.service.MovieService;
import phim.itsol.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final MovieService movieService;

    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/find-one/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        log.trace("REST to request get movie: {}", movieName);
//        MovieDto movieDto = movieService.getMovieByName(movieName);
        Movie movie = movieService.getMovieByName(movieName);
        if(movie==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Movie>> getAllMovie(){
        log.trace("REST to request get all seat.");
        return new ResponseEntity<>(movieService.getAllMovie(), HttpStatus.OK);
    }
    @GetMapping("/get-all/{movieName}")
    public ResponseEntity<List<Movie>> getAllMoviesByName(@PathVariable String movieName){
        log.trace("REST to request get movie: {}", movieName);
        return new ResponseEntity<>(movieService.getAllMoviesByName(movieName), HttpStatus.OK);
    }
    @GetMapping("/findone/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId){
        log.trace("REST to request get movie: {}", movieId);
//        MovieDto movieDto = movieService.getMovieByName(movieName);
        Movie movie = movieService.getMovieById(movieId);
        if(movie==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveMovie(@RequestBody MovieDto movieDto){
        log.trace("REST to request create movie: {}", movieDto);
        try{
            movieService.create(movieDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateMovie(@RequestBody MovieDto movieDto){
        log.trace("REST to request update movie: {}", movieDto);
        try{
            movieService.update(movieDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId){
        log.trace("REST to request delete movie: {}", movieId);
        try{
            movieService.delete(movieId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
