package phim.itsol.service;

import phim.itsol.domain.Schedule;
import phim.itsol.domain.Ticket;
import phim.itsol.dto.SeatDto;
import phim.itsol.dto.TicketDto;

import java.util.List;

public interface TicketService {
    /**
     * Count ticket
     * @param scheduleId
     * @return
     */
    int countTicketBySchedule(Long scheduleId,String ticketStatus);


    /**
     * create ticket
     *
     * @param ticketDto
     */
    void create(TicketDto ticketDto);
    /**
     * create ticket
     *
     * @param ticketDto
     */
    void createByCustomer(TicketDto ticketDto,Long customerId);
    /**
     * Get all ticket
     *
     * @return
     */
    List<Ticket> getTicketByCustomer(Long customerId,String ticketStatus);
}
