package phim.itsol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="CINEMA")
@Getter
@Setter
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CINEMA_SEQ")
    @SequenceGenerator(sequenceName = "CINEMA_SEQ", allocationSize = 1, name = "CINEMA_SEQ")
    private int cinema_id;

    @Column(name = "CINEMA_NAME", length = 50)
    private String cinema_name;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "SHORT_DES", length = 200)
    private String short_des;
}
