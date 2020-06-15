package phim.itsol.dto;

import lombok.*;
import phim.itsol.domain.Schedule;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class ScheduleDto {

    private Long scheduleId;

    private Long roomId;

    private Long movieId;

    private Date startTime;

    private Double moviePrice;

    public ScheduleDto(Schedule schedule) {
        this.scheduleId = scheduleId;
        this.roomId = roomId;
        this.movieId = movieId;
        this.startTime = startTime;
        this.moviePrice = moviePrice;
    }
}
