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
public class MovieRevenueDto {
    private Long movieId;
    private String movieName;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date endTime;
    private int totalOfMovieTicket;
    private double totalOfMoviePrice;

    public MovieRevenueDto(Long movieId, String movieName, double totalOfMoviePrice){
        this.movieId = movieId;
        this.movieName = movieName;
        this.totalOfMoviePrice = totalOfMoviePrice;
    }




}
