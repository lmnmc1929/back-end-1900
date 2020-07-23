package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phim.itsol.domain.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findMovieByMovieName(String movieName);
    List<Movie> findMoviesByMovieNameContains(String movieName);
    Movie findMovieByMovieId(Long movieId);
}
