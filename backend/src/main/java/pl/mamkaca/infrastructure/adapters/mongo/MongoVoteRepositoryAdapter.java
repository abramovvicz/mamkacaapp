package pl.mamkaca.infrastructure.adapters.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.mamkaca.application.ports.output.VoteRepository;
import pl.mamkaca.domain.Vote;
import pl.mamkaca.infrastructure.adapters.entity.VoteEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class MongoVoteRepositoryAdapter implements VoteRepository {

    private final MongoVoteRepositoryJpa mongoVoteRepositoryJpa;

    @Override
    public Vote save(Vote vote) {
        VoteEntity entity = mapToEntity(vote);
        VoteEntity savedEntity = mongoVoteRepositoryJpa.save(entity);
        return mapToDomain(savedEntity);
    }

    @Override
    public Optional<Vote> findByDeviceHashAndDate(String deviceHash, LocalDate date) {
        return mongoVoteRepositoryJpa.findByDeviceHashAndDate(deviceHash, date)
                .map(this::mapToDomain);
    }

    @Override
    public long countByDate(LocalDate date) {
        return mongoVoteRepositoryJpa.countByDate(date);
    }

    @Override
    public long countByDateAndHasHangover(LocalDate date, boolean hasHangover) {
        return mongoVoteRepositoryJpa.countByDateAndHasHangover(date, hasHangover);
    }

    @Override
    public long countByDateBetween(LocalDate startDate, LocalDate endDate) {
        return mongoVoteRepositoryJpa.countByDateBetween(startDate, endDate);
    }

    @Override
    public long countByDateBetweenAndHasHangover(LocalDate startDate, LocalDate endDate, boolean hasHangover) {
        return mongoVoteRepositoryJpa.countByDateBetweenAndHasHangover(startDate, endDate, hasHangover);
    }

    @Override
    public List<Vote> findByDateBetween(LocalDate startDate, LocalDate endDate) {
        return mongoVoteRepositoryJpa.findByDateBetween(startDate, endDate)
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    private VoteEntity mapToEntity(Vote vote) {
        return VoteEntity.builder()
                .id(vote.id())
                .deviceHash(vote.deviceHash())
                .date(vote.date())
                .hasHangover(vote.hasHangover())
                .createdAt(vote.createdAt())
                .build();
    }

    private Vote mapToDomain(VoteEntity entity) {
        return new Vote(entity.getId(), entity.getDeviceHash(), entity.getDate(), entity.isHasHangover(), entity.getCreatedAt());
    }
}