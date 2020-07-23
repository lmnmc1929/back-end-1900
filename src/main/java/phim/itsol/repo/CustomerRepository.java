package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Customer;

import java.util.Date;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByFullNameAndAndPhoneNumber(String fullName, String phoneNumber);
}
