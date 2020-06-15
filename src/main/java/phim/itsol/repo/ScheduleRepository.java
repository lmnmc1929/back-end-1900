package phim.itsol.repo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import phim.itsol.domain.Movie;
import phim.itsol.domain.Schedule;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    String GET_SCHEDULE_BY_MOVIE_ID = "getMovieName";

    @EntityGraph(attributePaths = "genreList")
    @Cacheable(cacheNames = GET_SCHEDULE_BY_MOVIE_ID)
    Optional<Schedule> findScheduleByMovieName(String movieName);
}
