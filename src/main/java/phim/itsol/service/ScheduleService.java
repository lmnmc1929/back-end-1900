package phim.itsol.service;

import phim.itsol.domain.Schedule;
import phim.itsol.dto.ScheduleDto;
import phim.itsol.exception.EmailExistException;
import phim.itsol.exception.UsernameExistException;

import java.util.Optional;

public interface ScheduleService {
    /**
     *
     * @return Optional<Schedule>
     */
    void Establish(ScheduleDto scheduleDto) throws UsernameExistException, EmailExistException;
    Optional<Schedule> getSchedule();
}
