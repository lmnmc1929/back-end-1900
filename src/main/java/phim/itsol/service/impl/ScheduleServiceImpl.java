package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Movie;
import phim.itsol.domain.Room;
import phim.itsol.domain.Schedule;
import phim.itsol.dto.ScheduleDto;
import phim.itsol.repo.ScheduleRepository;
import phim.itsol.service.ScheduleService;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)

public class ScheduleServiceImpl implements ScheduleService {
    private Logger log = LoggerFactory.getLogger(getClass());
    private final ScheduleRepository scheduleRepository;
    private final ModelMapper modelMapper;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Schedule> getAllSchedule() {
        log.trace("Service to get all Schedule");
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules;
    }

    @Override
    public List<Schedule> getAllScheduleByScheduleId(Long scheduleId) {
        return scheduleRepository.findScheduleById(scheduleId);
    }

    @Override
    public void create(ScheduleDto scheduleDto) {
        log.trace("Service to create room: {}", scheduleDto);
        Schedule schedule = modelMapper.map(scheduleDto, Schedule.class);

        Room room = new Room();
        room.setRoomId(schedule.getScheduleId());
        schedule.setRoom(room);

        Movie movie = new Movie();
        movie.setMovieId(schedule.getScheduleId());
        schedule.setMovie(movie);
        scheduleRepository.save(schedule);
    }

    @Override
    public void update(ScheduleDto scheduleDto) {
        log.trace("Service to update Schedule: {}", scheduleDto);
        Schedule scheduleDb = scheduleRepository.getOne(scheduleDto.getScheduleId());

        scheduleDb.setStartTime(scheduleDb.getStartTime());
        scheduleDb.setPriceMovie(scheduleDb.getPriceMovie());


        Room room = new Room();
        room.setRoomId(scheduleDto.getRoomId());
        scheduleDb.setRoom(room);

        scheduleRepository.save(scheduleDb);
    }

    @Override
    public void delete(Long ScheduleId) {
        scheduleRepository.deleteById(ScheduleId);
    }

    @Override
    public Schedule getSchedule(Long scheduleID) {
        return scheduleRepository.getOne(scheduleID);
    }
}
