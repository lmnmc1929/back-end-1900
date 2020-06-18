package phim.itsol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_SEQ")
    @SequenceGenerator(sequenceName = "MOVIE_SEQ", allocationSize = 1, name = "MOVIE_SEQ")
    @Column(name = "MOVIE_ID")
    private Long movieId;

    @ManyToMany
    @JoinTable(
            name = "MOVIE_GENRE",
            joinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GENRE_ID", referencedColumnName = "GENRE_ID")})
    @BatchSize(size = 20)
    @JsonIgnore
    private List<Genre> genreList;

    @Column(name = "MOVIE_NAME", length = 100)
    private String movieName;

    @Column(name = "MOVIE_YEAR")
    private String movieYear;

    @Column(name = "MOVIE_DURATION", length = 50)
    private String movieDuration;

    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    @OneToMany(targetEntity = MovieImage.class)
    @JsonIgnore
    private List<MovieImage> movieImageList;
}
