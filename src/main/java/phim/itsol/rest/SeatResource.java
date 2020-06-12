package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.dto.SeatDto;
import phim.itsol.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/api/seat")
public class SeatResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final SeatService seatService;

    public SeatResource(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<SeatDto>> getAllSeat(){
        log.trace("REST to request get all seat.");
        return new ResponseEntity<>(seatService.getAllSeat(), HttpStatus.OK);
    }
    @GetMapping("/get-all/{roomId}")
    public ResponseEntity<List<SeatDto>> getAllSeatByRoom(@PathVariable Long roomId){
        log.trace("REST to request get all seat in Room. {}", roomId);
        return new ResponseEntity<>(seatService.getAllSeatByRoom(roomId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveSeat(@RequestBody SeatDto seatDto){
        log.trace("REST to request create seat: {}", seatDto);
        try{
            seatService.create(seatDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-one/{seatId}")
    public ResponseEntity<SeatDto> getSeat(@PathVariable Long seatId){
        log.trace("REST to request get seat: {}", seatId);
        SeatDto seatDto = seatService.getSeat(seatId);
        if(seatDto==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(seatDto, HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateSeat(@RequestBody SeatDto seatDto){
        log.trace("REST to request update cinema: {}", seatDto);
        try{
            seatService.update(seatDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{seatId}")
    public ResponseEntity<Void> deleteCinema(@PathVariable Long seatId){
        log.trace("REST to request delete cinema: {}", seatId);
        try{
            seatService.delete(seatId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
