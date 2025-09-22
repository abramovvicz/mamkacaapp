package pl.mamkaca.application.ports.output;

import pl.mamkaca.domain.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VoteRepository {
    /**
     * Save a vote to the database
     * @param vote Vote to save
     * @return Saved vote
     */
    Vote save(Vote vote);

    /**
     * Find a vote by deviceHash and date
     * @param deviceHash Hashed device identifier
     * @param date Date of the vote
     * @return The vote if found
     */
    Optional<Vote> findByDeviceHashAndDate(String deviceHash, LocalDate date);

    /**
     * Count all votes for a specific date
     * @param date Date to count votes for
     * @return Count of votes
     */
    long countByDate(LocalDate date);

    /**
     * Count votes with hangover for a specific date
     * @param date Date to count votes for
     * @param hasHangover Whether to count votes with hangover
     * @return Count of votes with hangover
     */
    long countByDateAndHasHangover(LocalDate date, boolean hasHangover);

    /**
     * Count all votes between two dates inclusive
     * @param startDate Start date
     * @param endDate End date
     * @return Count of votes
     */
    long countByDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Count votes with hangover between two dates inclusive
     * @param startDate Start date
     * @param endDate End date
     * @param hasHangover Whether to count votes with hangover
     * @return Count of votes with hangover
     */
    long countByDateBetweenAndHasHangover(LocalDate startDate, LocalDate endDate, boolean hasHangover);

    /**
     * Find all votes between two dates
     * @param startDate Start date
     * @param endDate End date
     * @return List of votes
     */
    List<Vote> findByDateBetween(LocalDate startDate, LocalDate endDate);
}