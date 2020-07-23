package phim.itsol.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phim.itsol.domain.Customer;
import phim.itsol.domain.Movie;
import phim.itsol.domain.Schedule;
import phim.itsol.dto.CustomerDto;
import phim.itsol.dto.ScheduleDto;
import phim.itsol.service.CinemaService;
import phim.itsol.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/find-one")
    public ResponseEntity<Customer> getScheduleId(@RequestBody CustomerDto customerDto){
        log.trace("REST to request get schedule: {}", customerDto.getFullName());
        Customer customer = customerService.getCustomerByNDP(customerDto);
        if(customer==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        log.trace("REST to request get all seat.");
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
}
