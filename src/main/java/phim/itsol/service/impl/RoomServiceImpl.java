package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Cinema;
import phim.itsol.domain.Room;
import phim.itsol.dto.RoomDto;
import phim.itsol.repo.RoomRepository;
import phim.itsol.service.RoomService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoomServiceImpl implements RoomService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;
    public RoomServiceImpl(RoomRepository roomRepository, ModelMapper modelMapper) {
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Room> getAllRoom() {
        log.trace("Service to get all Room");
        List<Room> rooms = roomRepository.findAll();
        return rooms;
    }

    @Override
    public List<Room> getAllRoomByCinemaId(Long cinemaId) {
        return roomRepository.findRoomsByCinema_CinemaId(cinemaId);
    }

    @Override
    public void create(RoomDto roomDto) {
        log.trace("Service to create room: {}", roomDto);
        Room room = modelMapper.map(roomDto, Room.class);

        Cinema cinema = new Cinema();
        cinema.setCinemaId(roomDto.getCinemaId());
        room.setCinema(cinema);

        roomRepository.save(room);
    }

    @Override
    public void update(RoomDto roomDto) {
        log.trace("Service to update Room: {}", roomDto);
        Room roomDb = roomRepository.getOne(roomDto.getRoomId());

        roomDb.setRoomName(roomDto.getRoomName());
        roomDb.setSeatNum(roomDto.getSeatNum());
        roomDb.setType(roomDto.getType());

        Cinema cinema = new Cinema();
        cinema.setCinemaId(roomDto.getCinemaId());
        roomDb.setCinema(cinema);

        roomRepository.save(roomDb);
    }

    @Override
    public void delete(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public Room getRoom(Long roomId) {

        return roomRepository.getOne(roomId);
    }
}
