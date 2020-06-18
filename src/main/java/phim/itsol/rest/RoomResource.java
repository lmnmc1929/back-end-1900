package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.domain.Cinema;
import phim.itsol.domain.Room;
import phim.itsol.dto.RoomDto;
import phim.itsol.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Room>> getAllRoom(){
        log.trace("REST to request get all cinema.");
        return new ResponseEntity<>(roomService.getAllRoom(), HttpStatus.OK);
    }

    @GetMapping("/getbycinemaid/{cinemaId}")
    public ResponseEntity<List<Room>> getAllRoomByCinemaId(@PathVariable Long cinemaId){
        log.trace("REST to request get all cinema.");
        return new ResponseEntity<>(roomService.getAllRoomByCinemaId(cinemaId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveRoom(@RequestBody RoomDto roomDto){
        log.trace("REST to request create room: {}", roomDto);
        try{
            roomService.create(roomDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find-one/{roomId}")
    public ResponseEntity<Room> getRoom(@PathVariable Long roomId){
        log.trace("REST to request get room: {}", roomId);
        Room room = roomService.getRoom(roomId);
        if(room==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateRoom(@RequestBody RoomDto room){
        log.trace("REST to request update room: {}", room);
        try{
            roomService.update(room);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId){
        log.trace("REST to request delete room: {}", roomId);
        try{
            roomService.delete(roomId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
