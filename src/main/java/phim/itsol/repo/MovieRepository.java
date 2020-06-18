package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Movie;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findMovieByMovieId(Long movieId);
}
