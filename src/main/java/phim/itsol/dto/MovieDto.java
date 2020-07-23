package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Genre;
import phim.itsol.domain.MovieImage;

import java.util.Date;
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
    private String movieDuration;
    private String description;
    private List<MovieImage> movieImageList;
    private List<Genre> genreList;
    private List<String> genreIds;
    private List<String> movieImageUrls;
}
