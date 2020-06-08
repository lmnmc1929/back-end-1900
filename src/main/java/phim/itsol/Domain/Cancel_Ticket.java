package phim.itsol.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CANCEL_TICKET")
@Data
@Getter
@Setter

public class Cancel_Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCEL_TICKET_SEQ")
    @SequenceGenerator(name = "CANCEL_TICKET_SEQ", sequenceName = "CANCEL_TICKET_SEQ", allocationSize = 1)
    @Column(name = "CANCEL_TICKET_ID")
    private long CancelTicketId;

    @Column(name = "CANCEL_TIME")
    private Date Cancel_Time;

}
