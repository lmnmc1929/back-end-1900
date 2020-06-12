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
    @Column(name = "PRODUCT_ID")
    private Long scheduleId;

    @OneToOne(targetEntity = Room.class)
    private Room room;

    @OneToOne(targetEntity = Movie.class)
    private Movie movie;

    @Column(name = "START_TIME")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "PRICE_MOVIE")
    private double priceMovie;
}
