package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phim.itsol.dto.CancelTicketDto;
import phim.itsol.dto.TicketDto;
import phim.itsol.service.CancelTicketService;


@RestController
@RequestMapping("/api/cancelticket")
public class CancelTicketResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final CancelTicketService cancelTicketService;

    public CancelTicketResource(CancelTicketService cancelTicketService) {
        this.cancelTicketService = cancelTicketService;
    }
    @PostMapping("/create")
    public ResponseEntity<Void> saveCancelTicket(@RequestBody CancelTicketDto cancelTicketDto){
        log.trace("REST to request create ticket: {}", cancelTicketDto);
        try{
            cancelTicketService.createByTicket(cancelTicketDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
