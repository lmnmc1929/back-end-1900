package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phim.itsol.domain.Movie;
import phim.itsol.dto.ExportCinemaRevenue;
import phim.itsol.dto.ExportMovieRevenue;

import java.util.Date;
import java.util.List;

public interface MovieRevenueRepository extends JpaRepository<Movie, Long> {
    // query get top revenue by movie
//    @Query("select m.movieId,m.movieName, Sum(st.seatPrice + s.priceMovie) from Movie m" +
//            " inner join Schedule s on m.movieId = s.movie.movieId" +
//            " inner join Ticket t on t.schedule.scheduleId = s.scheduleId" +
//            " inner join Seat se on se.seatId = t.seat.seatId" +
//            " inner join SeatType st on se.seatType.seatTypeId = st.seatTypeId" +
//            " WHERE s.startTime > ?1 AND s.startTime < ?2 " +
//            " group by m.movieId,m.movieName")

    @Query(value = "select m.movie_id as movieId,m.movie_name as movieName, sum(st.seat_price + s.price_movie) as totalOfMoviePrice from Movie m " +
            "inner join Schedule s on s.movie_id = m.movie_id " +
            "inner join Ticket t on t.schedule_id = s.schedule_id " +
            "inner join Seat se on se.seat_id = t.seat_id " +
            "inner join Seat_type st on se.seat_type_id = st.seat_type_id " +
            "where s.start_time >  ?1 and s.start_time < ?2 " +
            "group by m.movie_id,m.movie_name",nativeQuery = true)
    List<ExportMovieRevenue> getTopRevenueByMovie(Date startTime, Date endTime);

    // count ticket by movie Id
//    @Query("SELECT m.movieId,count(t) as totalOfMovieTicket from Ticket t" +
//            " inner join Schedule s on t.schedule.scheduleId = s.scheduleId" +
//            " inner join Movie m on s.movie.movieId = s.movie.movieId" +
//            " WHERE m.movieId = ?1 AND s.startTime > ?2 AND s.startTime < ?3" +
//            " group by m.movieId")
    @Query(value = "select count(*) from Ticket t " +
            "inner join Schedule s on t.schedule_id = s.schedule_id " +
            "inner join Movie m on s.movie_id = m.movie_id " +
            "where m.movie_id = ?1 AND s.start_time >= ?2 AND s.start_time <= ?3 " +
            "group by m.movie_id", nativeQuery = true)
    int getCountTicketByMovie(Long movieId, Date startTime, Date endTime);

    // query get top revenue by Cinema
    @Query("select c.cinemaId,c.cinemaName, Sum(st.seatPrice + s.priceMovie) as totalOfMoviePrice from Cinema c" +
            " inner join Room r on r.cinema.cinemaId = c.cinemaId" +
            " inner join Schedule s on s.room.roomId = r.roomId" +
            " inner join Seat se on se.room.roomId = r.roomId" +
            " inner join SeatType st on se.seatType.seatTypeId = st.seatTypeId" +
            " WHERE s.startTime > ?1 AND s.startTime < ?2" +
            " group by c.cinemaId,c.cinemaName")
    List<ExportCinemaRevenue> getTopRevenueByCinema(Date startTime, Date endTime);

    // query count ticket by Cinema
    @Query("SELECT count(t) as totalOfMovieTicket from Ticket t" +
            " inner join Schedule s on t.schedule.scheduleId = s.scheduleId" +
            " inner join Cinema c on c.cinemaId = t.cinema.cinemaId" +
            " WHERE c.cinemaId = ?1 AND s.startTime > ?2 AND s.startTime < ?3" +
            " group by c.cinemaId")
     int getCountTicketByCinema(Long cinemaId , Date startTime, Date endTime);




}
