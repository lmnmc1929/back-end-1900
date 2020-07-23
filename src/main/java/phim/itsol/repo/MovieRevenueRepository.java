package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phim.itsol.domain.Manager;

public interface MovieRevenue extends JpaRepository<MovieRevenue,Long> {
    @Query("select m.movieId,m.movieName from Movie m" +
            " inner join Schedule s on m.movieId = s.movie.movieId WHERE s.date > ?1 AND s.date < ?2")
    MovieRevenue getTopRevenue();
    @Query("SELECT count(t) from Ticket t" +
            " inner join Schedule s on t.schedule.scheduleId = ")
    MovieRevenue getCountRevenue();
}
