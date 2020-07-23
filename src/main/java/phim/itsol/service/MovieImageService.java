package phim.itsol.service;

import phim.itsol.domain.Genre;
import phim.itsol.domain.MovieImage;

public interface MovieImageService {
    MovieImage getGenreById(Long genreId);
}
