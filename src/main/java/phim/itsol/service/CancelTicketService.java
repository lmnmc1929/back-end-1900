package phim.itsol.service;

import phim.itsol.domain.CancelTicket;
import phim.itsol.dto.CancelTicketDto;
import phim.itsol.dto.TicketDto;

public interface CancelTicketService {
    /**
     * create cancel_ticket
     *
     * @param cancelTicketDto
     */
    void createByTicket(CancelTicketDto cancelTicketDto);
}
