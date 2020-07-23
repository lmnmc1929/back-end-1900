package phim.itsol.rest;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phim.itsol.dto.*;
import phim.itsol.service.MovieRevenueService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/revenue")
public class MovieRevenueResource {
    private Logger log = LoggerFactory.getLogger(getClass());

    private final MovieRevenueService movieRevenueService;
    private final ModelMapper modelMapper;
    public MovieRevenueResource(MovieRevenueService movieRevenueService, ModelMapper modelMapper) {
        this.movieRevenueService = movieRevenueService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/get-revenue-by-movie")
    public ResponseEntity<List<MovieRevenueDto>> getTopRevenueByMovie(@RequestBody MovieRevenueDto movieRevenueDto){
        List<ExportMovieRevenue> exportMovieRevenue = movieRevenueService.getTopRevenueByMovie(movieRevenueDto.getStartTime(), movieRevenueDto.getEndTime());
        List<MovieRevenueDto> movieRevenueDtoList = new ArrayList<>();
        for(ExportMovieRevenue emr : exportMovieRevenue){
            MovieRevenueDto mrd = new MovieRevenueDto();
            mrd.setMovieId(emr.getMovieId());
            mrd.setMovieName(emr.getMovieName());
            mrd.setTotalOfMoviePrice(emr.getTotalOfMoviePrice());
            mrd.setStartTime(movieRevenueDto.getStartTime());
            mrd.setEndTime(movieRevenueDto.getEndTime());
            movieRevenueDtoList.add(mrd);
        }

        for(MovieRevenueDto mrd : movieRevenueDtoList) {
            if (mrd.getTotalOfMoviePrice()!=0)
                mrd.setTotalOfMovieTicket(movieRevenueService.getCountTicketByMovie(mrd.getMovieId(),movieRevenueDto.getStartTime(),movieRevenueDto.getEndTime()));
            else mrd.setTotalOfMovieTicket(0);
        }

        return new ResponseEntity<>(movieRevenueDtoList, HttpStatus.OK);

    }
    @PostMapping("/get-revenue-by-schedule")
    public ResponseEntity<List<ScheduleRevenueDto>> getAllRevenueScheduleByMovie(@RequestBody ScheduleRevenueDto scheduleRevenueDto){
        List<ExportScheduleRevenue> movieRevenueDtoList = movieRevenueService.getAllRevenueScheduleByMovie(scheduleRevenueDto.getMovieId()
                ,scheduleRevenueDto.getStartTime(),scheduleRevenueDto.getEndTime());
        List<ScheduleRevenueDto> scheduleRevenueDtos = new ArrayList<>();
        for(ExportScheduleRevenue esr : movieRevenueDtoList){
            ScheduleRevenueDto srd = new ScheduleRevenueDto();
            srd.setScheduleId(esr.getScheduleId());
            srd.setStartTime(esr.getStartTime());
            srd.setRoomName(esr.getRoomName());
            srd.setTotalMoney(esr.getTotalMoney());
            scheduleRevenueDtos.add(srd);
        }
        return new ResponseEntity<>(scheduleRevenueDtos, HttpStatus.OK);

    }

    @PostMapping("/get-revenue-by-cinema")
    public ResponseEntity<List<CinemaRevenueDto>> getTopRevenueByCinema(@RequestBody CinemaRevenueDto cinemaRevenueDto){

        List<ExportCinemaRevenue> exportCinemaRevenues = movieRevenueService.getTopRevenueByCinema(cinemaRevenueDto.getStartTime(), cinemaRevenueDto.getEndTime());
        List<CinemaRevenueDto> cinemaRevenueDtoList = new ArrayList<>();
        for (ExportCinemaRevenue ecr : exportCinemaRevenues) {
            CinemaRevenueDto crd = new CinemaRevenueDto();
            crd.setCinemaId(ecr.getCinemaId());
            crd.setCinemaName(ecr.getCinemaName());
            crd.setTotalOfMoviePrice(ecr.getTotalOfMoviePrice());
            crd.setStartTime(cinemaRevenueDto.getStartTime());
            crd.setEndTime(cinemaRevenueDto.getEndTime());
            cinemaRevenueDtoList.add(crd);

        }

        for(CinemaRevenueDto crd : cinemaRevenueDtoList) {
            if (crd.getTotalOfMoviePrice()!=0)
                crd.setTotalOfMovieTicket(movieRevenueService.getCountTicketByCinema(crd.getCinemaId(),crd.getStartTime(),crd.getEndTime()));
            else crd.setTotalOfMovieTicket(0);
        }
        return new ResponseEntity<>(cinemaRevenueDtoList, HttpStatus.OK);
    }




}
