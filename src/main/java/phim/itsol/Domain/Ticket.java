package phim.itsol.domain;

import javax.persistence.*;
import java.util.Date;

public class Ticket {
    @OneToOne(targetEntity = CancelTicket.class)
    private CancelTicket CancelTicket;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
    @SequenceGenerator(name = "TICKET_SEQ", sequenceName = "TICKET_SEQ", allocationSize = 1)
    @Column(name = "TICKET_ID")
    private long ticketId;

    @Column(name = "BOOKING_TIME")
    private Date bookingTime;
}
