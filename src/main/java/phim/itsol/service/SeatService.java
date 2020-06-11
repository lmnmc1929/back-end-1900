package phim.itsol.service;

import phim.itsol.domain.Cinema;
import phim.itsol.domain.Seat;
import phim.itsol.dto.SeatDto;

import java.util.List;

public interface SeatService {
    /**
     * Get all seat
     *
     * @return
     */
    List<SeatDto> getAllSeat();
    /**
     * Get all seat
     *
     * @return
     */
    List<SeatDto> getAllSeatByRoom(Long roomId);
    /**
     * create seat
     *
     * @param seatDto
     */

    void create(SeatDto seatDto);

    /**
     * update seat
     *
     * @param seatDto
     */
    void update(SeatDto seatDto);

    /**
     *
     * @param seatId
     */
    void delete(Long seatId);

    /**
     * Get one seat
     * @param seatId
     * @return
     */
    SeatDto getSeat(Long seatId);
}
