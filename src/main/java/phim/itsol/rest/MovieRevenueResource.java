package phim.itsol.rest;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phim.itsol.dto.CinemaRevenueDto;
import phim.itsol.dto.ExportCinemaRevenue;
import phim.itsol.dto.ExportMovieRevenue;
import phim.itsol.dto.MovieRevenueDto;
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

    @GetMapping("/get-revenue-by-movie")
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
            mrd.setTotalOfMovieTicket(movieRevenueService.getCountTicketByMovie(mrd.getMovieId(),movieRevenueDto.getStartTime(),movieRevenueDto.getEndTime()));
        }

        return new ResponseEntity<>(movieRevenueDtoList, HttpStatus.OK);

    }

    @GetMapping("/get-revenue-by-cinema")
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
            crd.setTotalOfMovieTicket(movieRevenueService.getCountTicketByMovie(crd.getCinemaId(),crd.getStartTime(),crd.getEndTime()));
        }
        return new ResponseEntity<>(cinemaRevenueDtoList, HttpStatus.OK);
    }




}
