package phim.itsol.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SCHEDULE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULE_SEQ")
    @SequenceGenerator(sequenceName = "SCHEDULE_SEQ", allocationSize = 1, name = "SCHEDULE_SEQ")
    @Column(name = "SCHEDULE_ID")
    private Long scheduleId;

    @ManyToOne(targetEntity = Room.class)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @Column(name = "START_TIME")
    @Temporal(TemporalType.DATE)
    private Date startTime;

    @Column(name = "PRICE_MOVIE")
    private double priceMovie;
}
