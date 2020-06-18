package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Room;
import phim.itsol.domain.Schedule;

import java.util.List;

@Repository

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    List<Schedule> findScheduleById(Long cinemaId);
}
