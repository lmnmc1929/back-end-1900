package phim.itsol.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TICKET")
@Data
@Getter
@Setter

public class Ticket {
    @OneToOne(targetEntity = Customer.class)
    private Customer customer;

    @OneToOne(targetEntity = CancelTicket.class)
    private CancelTicket cancelTicket;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
    @SequenceGenerator(name = "TICKET_SEQ", sequenceName = "TICKET_SEQ", allocationSize = 1)
    @Column(name = "TICKET_ID")
    private long ticketId;

    @Column(name = "BOOKING_TIME")
    private Date bookingTime;
}
