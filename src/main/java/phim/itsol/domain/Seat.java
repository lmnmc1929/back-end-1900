package phim.itsol.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Seat {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_type_id")
    @JsonIgnore
    private SeatType seatType;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEAT_SEQ")
    @SequenceGenerator(sequenceName = "SEAT_SEQ", allocationSize = 1, name = "SEAT_SEQ")
    @Column(name = "SEAT_ID")
    private Long seatId;

    @Column(name = "SEAT_ROW", length = 20)
    private String seatRow;

    @Column(name = "SEAT_COLUMN")
    private int seatColumn;

}
