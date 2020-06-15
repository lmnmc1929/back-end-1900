package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Genre;
@Repository
public interface ManageMovieGenresRepository extends JpaRepository<Genre, Long> {
}
