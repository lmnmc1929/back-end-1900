package phim.itsol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ROOM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @ManyToOne
    @JoinColumn(name="CINEMA_ID")
    private Cinema cinema;

    @OneToMany(targetEntity = Seat.class)
    private List<Seat> seatList;

    @OneToMany(targetEntity = Schedule.class)
    private List<Schedule> scheduleList;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ")
    @SequenceGenerator(sequenceName = "ROOM_SEQ", allocationSize = 1, name = "ROOM_SEQ")
    @Column(name = "ROOM_ID")
    private Long roomId;

    @Column(name = "ROOM_NAME", length = 100)
    private String roomName;

    @Column(name = "SEAT_NUM")
    private int seatNum;

    @Column(name = "TYPE", length = 100)
    private String type;



}
