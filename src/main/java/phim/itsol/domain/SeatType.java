package phim.itsol.domain;

import javax.persistence.*;
import java.util.List;

public class SeatType {
    @OneToMany(targetEntity = Seat.class)
    private List<Seat> seatList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEAT_TYPE_SEQ")
    @SequenceGenerator(sequenceName = "SEAT_TYPE_SEQ", allocationSize = 1, name = "SEAT_TYPE_SEQ")
    private Long seatTypeId;

    @Column(name = "SEAT_NAME", length = 20)
    private String seatTypeName;

    @Column(name = "SEAT_PRICE", length = 20)
    private double seatPrice;
}
