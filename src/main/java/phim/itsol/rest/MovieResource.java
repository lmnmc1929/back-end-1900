package phim.itsol.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.domain.Movie;
import phim.itsol.dto.MovieDto;
import phim.itsol.service.MovieService;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieResource {
    Logger log = LoggerFactory.getLogger(MovieResource.class);

    private final MovieService movieService;

    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/get-all-movie")
    public ResponseEntity<List<Movie>> getAllMovie(){
        log.trace("REST to request get all movie.");
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
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

    @GetMapping("/find-one/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long movieId){
        log.trace("REST to request get room: {}", movieId);
        Movie movie = movieService.getMovie(movieId);
        if(movie==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{movieId}")
    public ResponseEntity<Void> updateMovie(@RequestBody MovieDto movie){
        log.trace("REST to request update movie: {}", movie);
        try{
            movieService.update(movie);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId){
        log.trace("REST to request delete room: {}", movieId);
        try{
            movieService.delete(movieId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
