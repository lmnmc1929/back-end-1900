package phim.itsol.service;

import phim.itsol.dto.ExportCinemaRevenue;
import phim.itsol.dto.ExportMovieRevenue;

import java.util.Date;
import java.util.List;


public interface MovieRevenueService {
    List<ExportMovieRevenue> getTopRevenueByMovie(Date startTime, Date endTime);
    int getCountTicketByMovie(Long movieId , Date startTime, Date endTime);

    List<ExportCinemaRevenue> getTopRevenueByCinema(Date startTime, Date endTime);
    int getCountTicketByCinema(Long cinemaId , Date startTime, Date endTime);
}
