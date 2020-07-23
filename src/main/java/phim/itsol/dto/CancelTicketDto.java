package phim.itsol.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CancelTicketDto {
    private Long cancelTicketId;
    private Long ticketId;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date cancelTime;
}
