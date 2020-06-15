package phim.itsol.service;

import phim.itsol.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface ManageMovieGenresService {

    List<Genre> getAllGenres();
    void create(Genre genre);
    void update(Genre genre);
    void delete(Long genreId);
    Genre getGenre(Long genreId);

}
