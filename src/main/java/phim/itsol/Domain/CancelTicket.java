package phim.itsol.domain;

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

public class CancelTicket {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCEL_TICKET_SEQ")
    @SequenceGenerator(name = "CANCEL_TICKET_SEQ", sequenceName = "CANCEL_TICKET_SEQ", allocationSize = 1)
    @Column(name = "CANCEL_TICKET_ID")
    private long cancelTicketId;

    @Column(name = "CANCEL_TIME")
    private Date cancelTime;
}
