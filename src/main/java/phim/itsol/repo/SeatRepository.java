package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Seat;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByRoom(Long roomId);
    Seat findBySeatColumnAndSeatRowAndAndRoom(int column, String row, Long roomId);
    List<Seat> findSeatsByRoom_RoomId(Long roomId);
}
