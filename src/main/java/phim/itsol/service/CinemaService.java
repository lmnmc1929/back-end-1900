package phim.itsol.service;

import phim.itsol.domain.Cinema;

import java.util.List;

public interface CinemaService {
    /**
     * Get all cinema
     *
     * @return
     */
    List<Cinema> getAllCinema();

    /**
     * create cinema
     *
     * @param cinema
     */
    void create(Cinema cinema);

    /**
     * update cinema
     *
     * @param cinema
     */
    void update(Cinema cinema);

    /**
     *
     * @param cinemaId
     */
    void delete(Long cinemaId);

    /**
     * Get one cinema
     * @param cinemaId
     * @return
     */
    Cinema getCinema(Long cinemaId);
}
