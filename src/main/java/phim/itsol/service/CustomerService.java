package phim.itsol.service;

import phim.itsol.domain.Customer;
import phim.itsol.dto.CustomerDto;

import java.util.Date;
import java.util.List;

public interface CustomerService {
    Customer getCustomerByNDP(CustomerDto customerDto);
    List<Customer> getAllCustomer();
}
