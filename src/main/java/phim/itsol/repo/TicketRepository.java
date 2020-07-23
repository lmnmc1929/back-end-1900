package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Schedule;
import phim.itsol.domain.Ticket;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    int countBySchedule_ScheduleIdAndTicketStatus(Long scheduleId,String ticketStatus);
    List<Ticket> findTicketsByCustomer_CustomerIdAndTicketStatus(Long customerId,String ticketStatus);
}
