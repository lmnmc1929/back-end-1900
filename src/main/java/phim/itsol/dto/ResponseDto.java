package phim.itsol.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDto {
    private String message;
    private int responseCode;
    private Object dataResponse;
}
