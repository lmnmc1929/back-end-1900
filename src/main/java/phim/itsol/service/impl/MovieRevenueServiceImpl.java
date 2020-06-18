package phim.itsol.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.dto.ExportCinemaRevenue;
import phim.itsol.dto.ExportMovieRevenue;
import phim.itsol.repo.MovieRevenueRepository;
import phim.itsol.service.MovieRevenueService;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MovieRevenueServiceImpl implements MovieRevenueService {


    private final MovieRevenueRepository movieRevenueRepository;

    public MovieRevenueServiceImpl(MovieRevenueRepository movieRevenueRepository) {
        this.movieRevenueRepository = movieRevenueRepository;
    }


//    @Override
//    public List<MovieRevenueDto> getTopRevenueByMovie(Date startTime, Date endTime) {
//        return movieRevenueRepository.getTopRevenueByMovie(startTime,endTime);
//    }
@Override
    public List<ExportMovieRevenue> getTopRevenueByMovie(Date startTime, Date endTime) {
        return movieRevenueRepository.getTopRevenueByMovie(startTime,endTime);
    }

    @Override
    public int getCountTicketByMovie(Long movieId, Date startTime, Date endTime) {
        return movieRevenueRepository.getCountTicketByMovie(movieId,startTime,endTime);
    }

    @Override
    public List<ExportCinemaRevenue> getTopRevenueByCinema(Date startTime, Date endTime) {
        return movieRevenueRepository.getTopRevenueByCinema(startTime,endTime);
    }

    @Override
    public int getCountTicketByCinema(Long cinemaId, Date startTime, Date endTime) {
        return movieRevenueRepository.getCountTicketByCinema(cinemaId,startTime,endTime);
    }


}
