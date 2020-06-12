package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Cinema;
import phim.itsol.domain.Room;
import phim.itsol.domain.Schedule;
import phim.itsol.domain.Seat;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RoomDto {

    private Long roomId;
    private Long cinemaId;
    private String roomName;
    private int seatNum;
    private String type;
    private List<Seat> seatList;
    private List<Schedule> scheduleList;
    private Cinema cinema;


}
