package pl.mamkaca.infrastructure.adapters.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mamkaca.application.ports.input.VoteService;
import pl.mamkaca.domain.Vote;

import java.time.LocalDate;

import static org.springframework.http.ResponseEntity.*;
import static pl.mamkaca.infrastructure.adapters.rest.VoteResponse.*;

@Slf4j
@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<VoteResponse> registerVote(@Valid @RequestBody VoteRequest request) {
        // Check if already voted today
        log.info("RegisterVote executed. Already voted today");
        if (voteService.hasVotedToday(request.getDeviceId())) {
            VoteResponse response = builder()
                    .success(false)
                    .message("You have already voted today")
                    .date(LocalDate.now())
                    .build();
            return badRequest().body(response);
        }

        // Register vote
        var registeredVote = voteService.registerVote(request.getDeviceId(), request.isHasHangover());

        var response = builder()
                .success(true)
                .message("Vote registered successfully")
                .date(registeredVote.date())
                .hasHangover(registeredVote.hasHangover())
                .build();
        log.debug("RegisterVote response={}", response);
        return ok(response);
    }

    @GetMapping("/check")
    public ResponseEntity<VoteResponse> checkVote(@RequestParam String deviceId) {
        boolean hasVoted = voteService.hasVotedToday(deviceId);
        log.debug("CheckVote executed. HasVoted today: {}", hasVoted);

        var response = builder()
                .success(true)
                .message(hasVoted ? "Already voted today" : "Not voted today")
                .date(LocalDate.now())
                .build();
        log.debug("CheckVote response={}", response);
        return ok(response);
    }
}