package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Genre;
import phim.itsol.domain.MovieImage;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class MovieDto {
    private Long movieId;

    private String movieName;

    private String movieYear;

    private String duration;

    private String description;

    private List<MovieImage> movieImageID;

    private List<Genre> genreList;

    private String[] genres;

//    public MovieDto(Movie movie){
//        this.movieId = movie.getMovieId();
//        this.movieName = movie.getMovieName();
//        this.movieYear = movie.getMovieYear();
//        this.duration = movie.getMovieDuration();
//        this.description = movie.getDescription();
//        this.movieImageID = movie.getMovieImageList();
//        this.genreList = movie.getGenreList();
//    }
}
