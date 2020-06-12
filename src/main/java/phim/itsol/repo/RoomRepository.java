package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Cinema;
import phim.itsol.domain.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findRoomsByCinema_CinemaId(Long cinemaId);
}
