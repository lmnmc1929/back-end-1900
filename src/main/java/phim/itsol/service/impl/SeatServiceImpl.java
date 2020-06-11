package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Cinema;
import phim.itsol.domain.Room;
import phim.itsol.domain.Seat;
import phim.itsol.domain.SeatType;
import phim.itsol.dto.SeatDto;
import phim.itsol.repo.SeatRepository;
import phim.itsol.service.SeatService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class SeatServiceImpl implements SeatService {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final SeatRepository seatRepository;
//    private final RoomRepository seatRepository;
private final ModelMapper modelMapper;
    public SeatServiceImpl(SeatRepository seatRepository, ModelMapper modelMapper) {
        this.seatRepository = seatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SeatDto> getAllSeat() {
        log.trace("Service to get all Seat");
        List<Seat> seats = seatRepository.findAll();
        return seats.stream()
                .map(seat -> modelMapper.map(seat, SeatDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SeatDto> getAllSeatByRoom(Long roomId) {
        log.trace("Service to get all seat in Room");
        List<Seat> seats = seatRepository.findSeatsByRoom_RoomId(roomId);
        return seats.stream()
                .map(seat -> modelMapper.map(seat, SeatDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void create(SeatDto seatDto) {
//        Seat seat1 = seatRepository.findBySeatColumnAndSeatRowAndAndRoom(seat.getSeatColumn(),seat.getSeatRow(),seat.getRoom().getRoomId());
//        if(seat1 == null) {
            log.trace("Service to create Seat: {}", seatDto);

            Seat seat = modelMapper.map(seatDto, Seat.class);
            Room room = new Room();
            room.setRoomId(seatDto.getRoomId());
            seat.setRoom(room);
            SeatType seatType = new SeatType();
            seatType.setSeatTypeId(seatDto.getSeatTypeId());
            seat.setSeatType(seatType);
            seatRepository.save(seat);
//        }
    }

    @Override
    public void update(SeatDto seatDto) {
        log.trace("Service to update Seat: {}", seatDto);
//        Seat seat1 = seatRepository.findBySeatColumnAndSeatRowAndAndRoom(seatDto.getSeatColumn(),seat.getSeatRow(),seat.getRoom().getRoomId());
//        if(seat1 == null){
        Seat seatDb = seatRepository.getOne(seatDto.getSeatId());
        seatDb.setSeatColumn(seatDto.getSeatColumn());
        seatDb.setSeatRow(seatDto.getSeatRow());
        Room room = new Room();
        room.setRoomId(seatDto.getRoomId());
        seatDb.setRoom(room);
        SeatType seatType = new SeatType();
        seatType.setSeatTypeId(seatDto.getSeatTypeId());
        seatDb.setSeatType(seatType);
        seatRepository.save(seatDb);
//        }
    }

    @Override
    public void delete(Long seatId) {
        seatRepository.deleteById(seatId);
    }

    @Override
    public SeatDto getSeat(Long seatId) {
        log.trace("Service to get seat by seatId = {}", seatId);
        Optional<Seat> seatOptional = seatRepository.findById(seatId);
        return seatOptional
                .map(seat->modelMapper.map(seat, SeatDto.class))
                .orElse(null);
    }
}
