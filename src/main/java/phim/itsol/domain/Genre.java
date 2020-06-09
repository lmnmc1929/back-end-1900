package phim.itsol.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "GENRE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENRE_SEQ")
    @SequenceGenerator(sequenceName = "GENRE_SEQ", allocationSize = 1, name = "GENRE_SEQ")
    @Column(name = "GENRE_ID")
    private Long genreId;

    @Column(name = "GENRE_NAME", length = 50)
    private String genreName;
}
