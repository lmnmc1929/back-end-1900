package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Movie;
import phim.itsol.domain.Room;
import phim.itsol.domain.Ticket;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ScheduleDto {
    private Long scheduleId;
    private Long movieId;
    private Long roomId;
    private Room room;
    private Movie movie;
    private List<Ticket> ticketList;
}
