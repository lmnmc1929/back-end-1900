package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.domain.Cinema;
import phim.itsol.service.CinemaService;

import java.util.List;

@RestController
@RequestMapping("/api/cinema")
public class CinemaResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final CinemaService cinemaService;

    public CinemaResource(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Cinema>> getAllCinema(){
        log.trace("REST to request get all cinema.");
        return new ResponseEntity<>(cinemaService.getAllCinema(), HttpStatus.OK);
    }

    @PostMapping("/create/{cinemaId}")
    public ResponseEntity<Void> saveCinema(@RequestBody Cinema cinema){
        log.trace("REST to request create cinema: {}", cinema);
        try{
            cinemaService.create(cinema);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-one/{cinemaId}")
    public ResponseEntity<Cinema> getCinema(@PathVariable Long cinemaId){
        log.trace("REST to request get cinema: {}", cinemaId);
        Cinema cinema = cinemaService.getCinema(cinemaId);
        if(cinema==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cinema, HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCinema(@RequestBody Cinema cinema){
        log.trace("REST to request update cinema: {}", cinema);
        try{
            cinemaService.update(cinema);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{cinemaId}")
    public ResponseEntity<Void> deleteCinema(@PathVariable Long cinemaId){
        log.trace("REST to request delete cinema: {}", cinemaId);
        try{
            cinemaService.delete(cinemaId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
