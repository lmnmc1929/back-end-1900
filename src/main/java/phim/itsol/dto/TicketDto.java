package phim.itsol.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TicketDto {
    private Long ticketId;
    private Long cinemaId;
    private Long customerId;
    private Long scheduleId;
    private List<String> seatIds;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date bookingTime;
}
