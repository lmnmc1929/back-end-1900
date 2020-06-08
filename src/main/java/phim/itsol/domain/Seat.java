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

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name ="seat_type_id")
    private SeatType seatType;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEAT_SEQ")
    @SequenceGenerator(sequenceName = "SEAT_SEQ", allocationSize = 1, name = "SEAT_SEQ")
    private int seatId;

    @Column(name = "SEAT_NAME", length = 20)
    private String seatName;

}
