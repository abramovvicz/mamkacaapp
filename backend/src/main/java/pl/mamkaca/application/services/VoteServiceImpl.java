package pl.mamkaca.application.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import pl.mamkaca.application.ports.input.VoteService;
import pl.mamkaca.application.ports.output.VoteRepository;
import pl.mamkaca.domain.Vote;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Override
    public Vote registerVote(String deviceId, boolean hasHangover) {
        var deviceHash = hashDeviceId(deviceId);
        var today = LocalDate.now();

        // Check if device has already voted today
        if (hasVotedToday(deviceId)) {
            return null;
        }
        long timeStamp = System.currentTimeMillis();
        // Create new vote
        var vote = new Vote(deviceId, deviceHash, today, hasHangover, timeStamp);

        return voteRepository.save(vote);
    }

    @Override
    public boolean hasVotedToday(String deviceId) {
        var deviceHash = hashDeviceId(deviceId);
        var today = LocalDate.now();

        var existingVote = voteRepository.findByDeviceHashAndDate(deviceHash, today);
        return existingVote.isPresent();
    }

    private String hashDeviceId(String deviceId) {
        // Use SHA-256 to hash the device ID
        return DigestUtils.sha256Hex(deviceId);
    }
}