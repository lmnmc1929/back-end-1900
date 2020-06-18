package phim.itsol.service;

import phim.itsol.domain.Schedule;
import phim.itsol.dto.ScheduleDto;

import java.util.List;

public interface ScheduleService {

     List<Schedule> getAllSchedule();
     List<Schedule> getAllScheduleByScheduleId(Long cinemaId);
     void create(ScheduleDto scheduleDto);
     void update(ScheduleDto scheduleDto);
     void delete(Long ScheduleId);
     Schedule getSchedule(Long scheduleID);
}
