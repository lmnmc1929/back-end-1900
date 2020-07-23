package phim.itsol.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import phim.itsol.domain.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage,Long> {
    MovieImage findMovieImageByMovieImageId(Long movieImageId);
    MovieImage findMovieImageByUrl(String url);
    void deleteAllByMovie_MovieId(long movieId);
}
