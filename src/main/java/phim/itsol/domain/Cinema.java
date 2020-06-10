package phim.itsol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CINEMA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {
    @OneToMany(targetEntity = Room.class)
    private List<Room> roomList;

    @OneToMany(targetEntity = Manager.class, fetch = FetchType.EAGER)
    private List<Manager> managerList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CINEMA_SEQ")
    @SequenceGenerator(sequenceName = "CINEMA_SEQ", allocationSize = 1, name = "CINEMA_SEQ")
    private Long cinemaId;

    @Column(name = "CINEMA_NAME", length = 50)
    private String cinemaName;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "SHORT_DES", length = 200)
    private String shortDes;
}
