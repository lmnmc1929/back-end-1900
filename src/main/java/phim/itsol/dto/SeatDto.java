package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Room;
import phim.itsol.domain.SeatType;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SeatDto {
    private Long seatId;
    private Long roomId;
    private String seatRow;
    private int seatColumn;
    private Long seatTypeId;
//    private Room room;
//    private SeatType seatType;
}
