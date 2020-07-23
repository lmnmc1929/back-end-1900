package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.domain.Schedule;
import phim.itsol.domain.Ticket;
import phim.itsol.dto.SeatDto;
import phim.itsol.dto.TicketDto;
import phim.itsol.service.ScheduleService;
import phim.itsol.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final TicketService ticketService;


    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/count/{scheduleId}")
    public int countTicketBySchedule(@PathVariable Long scheduleId){
        log.trace("REST to request count ticket by scheduleId: {}", scheduleId);
        return ticketService.countTicketBySchedule(scheduleId,"Active");
    }
    @PostMapping("/create")
    public ResponseEntity<Void> saveTicket(@RequestBody TicketDto ticketDto){
        log.trace("REST to request create ticket: {}", ticketDto);
        try{
            ticketService.create(ticketDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createCustomer")
    public ResponseEntity<Void> saveTicketByCustomer(@RequestBody TicketDto ticketDto){
        log.trace("REST to request create ticket: {}", ticketDto);
        try{
            ticketService.createByCustomer(ticketDto,ticketDto.getCustomerId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get-all/{customerId}")
    public ResponseEntity<List<Ticket>> getTicketByCustomer(@PathVariable Long customerId){
        log.trace("REST to request get all Schedule. {}", customerId);
        return new ResponseEntity<>(ticketService.getTicketByCustomer(customerId,"Active"), HttpStatus.OK);
    }
}
