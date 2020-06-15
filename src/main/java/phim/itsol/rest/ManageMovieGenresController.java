package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.domain.Genre;
import phim.itsol.service.ManageMovieGenresService;

import java.util.List;

@RestController
@RequestMapping("/api/manager/genre")
public class ManageMovieGenresController {
    private Logger log = LoggerFactory.getLogger(getClass());
    private final ManageMovieGenresService manageMovieGenresService;
    public ManageMovieGenresController(ManageMovieGenresService manageMovieGenresService){
        this.manageMovieGenresService=manageMovieGenresService;
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Genre>> getAllGenre(){
        log.trace("rest to request get all genre");
        return new ResponseEntity<>(manageMovieGenresService.getAllGenres(),HttpStatus.OK);
    }

    @GetMapping("/find-one/{genreId}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long genreId){
        log.trace("rest to request get genre: {}",genreId);
        Genre genre = manageMovieGenresService.getGenre(genreId);
        if (genre==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(genre, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveGenre(@RequestBody Genre genre){
        log.trace("rest to request create:{}",genre);
        try {
            manageMovieGenresService.create(genre);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateGenre(@RequestBody Genre genre){
        log.trace("rest to request update genre",genre);
        try {
            manageMovieGenresService.update(genre);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{genreId}")
   public ResponseEntity<Void> deleteGenre(@PathVariable Long genreId){
        log.trace("rest to request delete genre",genreId);
        try {
            manageMovieGenresService.delete(genreId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
