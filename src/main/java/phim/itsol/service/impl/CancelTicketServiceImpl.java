package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.CancelTicket;
import phim.itsol.domain.Seat;
import phim.itsol.domain.Ticket;
import phim.itsol.dto.CancelTicketDto;
import phim.itsol.repo.CancelTicketRepository;
import phim.itsol.repo.TicketRepository;
import phim.itsol.service.CancelTicketService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional(rollbackFor = Exception.class)
public class CancelTicketServiceImpl implements CancelTicketService {
    private Logger log = LoggerFactory.getLogger(getClass());
    private final TicketRepository ticketRepository;
    private final CancelTicketRepository cancelTicketRepository;
    private final ModelMapper modelMapper;

    public CancelTicketServiceImpl(TicketRepository ticketRepository, CancelTicketRepository cancelTicketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.cancelTicketRepository = cancelTicketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createByTicket(CancelTicketDto cancelTicketDto) {
        log.trace("Service to create Ticket: {}", cancelTicketDto);
        Ticket ticket = ticketRepository.getOne(cancelTicketDto.getTicketId());
        ticket.setTicketStatus("Cancelled");
        ticketRepository.save(ticket);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            cancelTicketDto.setCancelTime(sdf.parse(dtf.format(now)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CancelTicket cancelTicket = modelMapper.map(cancelTicketDto, CancelTicket.class);
        cancelTicketRepository.save(cancelTicket);
    }
}
