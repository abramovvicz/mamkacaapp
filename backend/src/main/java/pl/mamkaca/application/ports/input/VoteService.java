package pl.mamkaca.application.ports.input;

import pl.mamkaca.domain.Vote;

public interface VoteService {
    /**
     * Register a vote from a device
     * @param deviceId Raw device identifier
     * @param hasHangover Whether the user has a hangover
     * @return Registered vote or null if device already voted today
     */
    Vote registerVote(String deviceId, boolean hasHangover);

    /**
     * Check if a device has already voted today
     * @param deviceId Raw device identifier
     * @return true if device has already voted today
     */
    boolean hasVotedToday(String deviceId);
}
