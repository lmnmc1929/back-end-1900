package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.CancelTicket;

@Repository
public interface CancelTicketRepository extends JpaRepository<CancelTicket, Long> {
}
