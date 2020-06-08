package phim.itsol.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE_IMAGE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_IMAGE_SEQ")
    @SequenceGenerator(sequenceName = "MOVIE_IMAGE_SEQ", allocationSize = 1, name = "MOVIE_IMAGE_SEQ")
    @Column(name = "MOVIE_IMAGE_ID")
    private Long movieImageId;

    @Column(name = "URL", length = 200)
    private String url;
}
