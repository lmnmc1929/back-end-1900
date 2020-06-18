package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phim.itsol.domain.Ticket;
import phim.itsol.dto.DayRevenueDto;

import java.util.Date;
import java.util.List;

public interface DayRevenueRepository extends JpaRepository<Ticket, Long> {
    //
    @Query("select s.startTime,SUM(s.priceMovie+st.seatPrice) as totalOfPrice from Ticket t " +
            "inner join Schedule s on s.scheduleId = t.schedule.scheduleId " +
            "inner join  Seat se on se.seatId = t.seat.seatId " +
            "inner join SeatType st on st.seatTypeId = se.seatType.seatTypeId " +
            "where s.startTime > ?1 AND s.startTime < ?2 " +
            "group by s.startTime")
    List<DayRevenueDto> getDayRevenue(Date startTime, Date endTime);

//    @Query()
//    List<Integer> getCountTicketPerDay(Date startTime, Date endTime);
}
