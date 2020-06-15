package phim.itsol.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phim.itsol.domain.Genre;
import phim.itsol.repo.ManageMovieGenresRepository;
import phim.itsol.service.ManageMovieGenresService;
import org.slf4j.Logger;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ManageMovieGenresServiceImpl implements ManageMovieGenresService {

    private Logger log = LoggerFactory.getLogger(getClass());
    private final ManageMovieGenresRepository manageMovieGenresRepository;

    public ManageMovieGenresServiceImpl(ManageMovieGenresRepository manageMovieGenresRepository, ModelMapper modelMapper){
        this.manageMovieGenresRepository = manageMovieGenresRepository;
    }
    @Override
    public List<Genre> getAllGenres() {
        log.trace("Service to get all Genre");
        List<Genre> genres = manageMovieGenresRepository.findAll();
        return genres;
    }


    @Override
    public void create(Genre genre){
        log.trace("service to create Gener:",genre);
        manageMovieGenresRepository.save(genre);
    }

    @Override
    public void update(Genre genre){
        log.trace("Service to update Genre",genre);
        Genre genreDB = manageMovieGenresRepository.getOne(genre.getGenreId());
        genreDB.setGenreName(genre.getGenreName());
    }
    @Override
    public void delete(Long genreId){
        manageMovieGenresRepository.deleteById(genreId);
    }
    @Override
    public Genre getGenre(Long genreId){
        return manageMovieGenresRepository.getOne(genreId);
    }
}
