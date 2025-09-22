package pl.mamkaca.infrastructure.adapters.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mamkaca.infrastructure.adapters.entity.VoteEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MongoVoteRepositoryJpa extends MongoRepository<VoteEntity, String> {
    Optional<VoteEntity> findByDeviceHashAndDate(String deviceHash, LocalDate date);

    long countByDate(LocalDate date);

    long countByDateAndHasHangover(LocalDate date, boolean hasHangover);

    long countByDateBetween(LocalDate startDate, LocalDate endDate);

    long countByDateBetweenAndHasHangover(LocalDate startDate, LocalDate endDate, boolean hasHangover);

    List<VoteEntity> findByDateBetween(LocalDate startDate, LocalDate endDate);

    long deleteByDateBefore(LocalDate date);

    @Query(value = "{ 'date': { $gte: ?0, $lte: ?1 } }", count = true)
    long countVotesInDateRange(LocalDate startDate, LocalDate endDate);

    @Query(value = "{ 'date': { $gte: ?0, $lte: ?1 }, 'hasHangover': ?2 }", count = true)
    long countVotesInDateRangeWithHangoverStatus(LocalDate startDate, LocalDate endDate, boolean hasHangover);
}
