package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Customer;
import phim.itsol.domain.Movie;
import phim.itsol.dto.CustomerDto;
import phim.itsol.repo.CinemaRepository;
import phim.itsol.repo.CustomerRepository;
import phim.itsol.service.CustomerService;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer getCustomerByNDP(CustomerDto customerDto) {
        log.trace("Service to update Customer: {}", customerDto.getFullName());
        return customerRepository.findCustomerByFullNameAndAndPhoneNumber(customerDto.getFullName(),customerDto.getPhoneNumber());
    }

    @Override
    public List<Customer> getAllCustomer() {
        log.trace("Service to get all Customer");
        List<Customer> customers = customerRepository.findAll();
//        return movies.stream()
//                .map(movie -> modelMapper.map(movie, MovieDto.class))
//                .collect(Collectors.toList());

        return customers;
    }
}
