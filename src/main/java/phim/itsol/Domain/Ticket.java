package phim.itsol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonIgnore
    private Customer customer;

//    @OneToOne(targetEntity = CancelTicket.class)
//    private CancelTicket cancelTicket;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CINEMA_ID")
    @JsonIgnore
    private Cinema cinema;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEAT_ID")
    @JsonIgnore
    private Seat seat;
    @ManyToOne(targetEntity = Schedule.class)
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
    @SequenceGenerator(name = "TICKET_SEQ", sequenceName = "TICKET_SEQ", allocationSize = 1)
    @Column(name = "TICKET_ID")
    private long ticketId;

    @Column(name = "BOOKING_TIME")
    private Date bookingTime;
}
