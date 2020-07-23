package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.*;
import phim.itsol.dto.TicketDto;
import phim.itsol.repo.TicketRepository;
import phim.itsol.service.TicketService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TicketServiceImpl implements TicketService {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public int countTicketBySchedule(Long scheduleId,String ticketStatus) {
        log.trace("Service to count ticket by scheduleId = {}", scheduleId);
        int count = ticketRepository.countBySchedule_ScheduleIdAndTicketStatus(scheduleId,"Active");
        return count;
    }

    @Override
    public void create(TicketDto ticketDto) {
        log.trace("Service to create Ticket: {}", ticketDto);
        for (String seatId: ticketDto.getSeatIds()) {
//            ticketDto.setTicketId(Long.parseLong(ticketId));
            Seat seat = new Seat();
            seat.setSeatId(Long.parseLong(seatId));

            Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
            ticket.setSeat(seat);
            ticketRepository.save(ticket);
        }
    }

    @Override
    public void createByCustomer(TicketDto ticketDto, Long customerId) {
        log.trace("Service to create Ticket: {}", ticketDto);
        for (String seatId: ticketDto.getSeatIds()) {
//            ticketDto.setTicketId(Long.parseLong(ticketId));
            Seat seat = new Seat();
            seat.setSeatId(Long.parseLong(seatId));
            ticketDto.setCustomerId(customerId);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            try {
                ticketDto.setBookingTime(sdf.parse(dtf.format(now)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
            ticket.setSeat(seat);
            ticketRepository.save(ticket);
        }
    }

    @Override
    public List<Ticket> getTicketByCustomer(Long customerId, String ticketStatus) {
        return ticketRepository.findTicketsByCustomer_CustomerIdAndTicketStatus(customerId,"Active");
    }
}
