package phim.itsol.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="SEAT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Seat {

    @OneToOne(targetEntity = Room.class)
    private Room room;

    @OneToOne(targetEntity = SeatType.class)
    private SeatType seatType;

    @OneToOne(targetEntity = Ticket.class)
    private Ticket ticket;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEAT_SEQ")
    @SequenceGenerator(sequenceName = "SEAT_SEQ", allocationSize = 1, name = "SEAT_SEQ")
    private int seatId;

    @Column(name = "SEAT_ROW", length = 20)
    private String seatRow;

    @Column(name = "SEAT_COLUMN")
    private int seatColumn;

}
