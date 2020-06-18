package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
