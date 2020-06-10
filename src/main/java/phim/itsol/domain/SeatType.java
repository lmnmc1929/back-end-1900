package phim.itsol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SEAT_TYPE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatType {
    @OneToMany(targetEntity = Seat.class)
    private List<Seat> seatList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEAT_TYPE_SEQ")
    @SequenceGenerator(sequenceName = "SEAT_TYPE_SEQ", allocationSize = 1, name = "SEAT_TYPE_SEQ")
    @Column(name = "SEAT_TYPE_ID")
    private Long seatTypeId;

    @Column(name = "SEAT_TYPE_NAME", length = 20)
    private String seatTypeName;

    @Column(name = "SEAT_TYPE_PRICE", length = 20)
    private double seatPrice;
}
