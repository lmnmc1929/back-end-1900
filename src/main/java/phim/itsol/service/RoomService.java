package phim.itsol.service;

import phim.itsol.domain.Room;
import phim.itsol.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<Room> getAllRoom();
    List<Room> getAllRoomByCinemaId(Long cinemaId);
    void create(RoomDto roomDto);
    void update(RoomDto roomDto);
    void delete(Long roomId);
    Room getRoom(Long roomId);
}
