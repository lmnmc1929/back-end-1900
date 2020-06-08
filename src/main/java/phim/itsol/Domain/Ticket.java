package phim.itsol.Domain;

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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
    @SequenceGenerator(name = "TICKET_SEQ", sequenceName = "TICKET_SEQ", allocationSize = 1)
    @Column(name = "TICKET_ID")
    private long Ticket_ID;

    @Column(name = "BOOKING_TIME")
    private Date Booking_Time;


}
