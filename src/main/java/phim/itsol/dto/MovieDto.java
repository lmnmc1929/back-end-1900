package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Genre;
import phim.itsol.domain.Movie;
import phim.itsol.domain.MovieImage;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class MovieDto {
    private Long movieId;

    private String movieName;

    private Date movieDate;

    private String duration;

    private String description;

    private List<MovieImage> movieImageID;

    private List<Genre> genreList;

    private String[] genres;

    public MovieDto(Movie movie){
        this.movieId = movie.getMovieId();
        this.movieName = movie.getMovieName();
        this.movieDate = movie.getMovieDate();
        this.duration = movie.getMovieDuration();
        this.description = movie.getDescription();
        this.movieImageID = movie.getMovieImageList();
        this.genreList = movie.getGenreList();
    }
}
