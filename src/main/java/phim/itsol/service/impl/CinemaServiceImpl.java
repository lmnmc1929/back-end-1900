package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Cinema;
import phim.itsol.repo.CinemaRepository;
import phim.itsol.service.CinemaService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CinemaServiceImpl implements CinemaService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private final CinemaRepository cinemaRepository;


    public CinemaServiceImpl(CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<Cinema> getAllCinema() {
        log.trace("Service to get all Cinema");
        List<Cinema> cinemas = cinemaRepository.findAll();
        return cinemas;
    }

    @Override
    public void create(Cinema cinema) {
        log.trace("Service to create Cinema: {}", cinema);
        cinemaRepository.save(cinema);
    }

    @Override
    public void update(Cinema cinema) {
        log.trace("Service to update Cinema: {}", cinema);
        Cinema cinemaDb = cinemaRepository.getOne(cinema.getCinemaId());
        cinemaDb.setCinemaName(cinema.getCinemaName());
        cinemaDb.setAddress(cinema.getAddress());
        cinemaDb.setShortDes(cinema.getShortDes());
        cinemaRepository.save(cinemaDb);
    }

    @Override
    public void delete(Long cinemaId) {
        cinemaRepository.deleteById(cinemaId);
    }

    @Override
    public Cinema getCinema(Long cinemaId) {
        return cinemaRepository.getOne(cinemaId);
    }
}
