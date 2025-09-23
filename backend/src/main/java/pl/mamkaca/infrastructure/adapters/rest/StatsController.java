package pl.mamkaca.infrastructure.adapters.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mamkaca.application.ports.input.StatsService;
import pl.mamkaca.domain.DateRange;
import pl.mamkaca.domain.Stats;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDate.*;

@Slf4j
@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/today")
    public ResponseEntity<StatsResponse> getTodayStats() {
        var stats = statsService.getDailyStats();
        log.info("Get stats for today:{}, stats:{}", now(), stats);
        return ResponseEntity.ok(mapToResponse(stats, "today"));
    }

    @GetMapping("/month")
    public ResponseEntity<StatsResponse> getMonthStats() {
        var stats = statsService.getMonthlyStats();
        log.info("Get stats for month:{} stats:{}", now().getMonth(), stats);
        return ResponseEntity.ok(mapToResponse(stats, "month"));
    }

    @GetMapping("/year")
    public ResponseEntity<StatsResponse> getYearStats() {
        var stats = statsService.getYearlyStats();
        log.info("Get stats for year:{}: stats:{}", now().getYear(), stats);
        return ResponseEntity.ok(mapToResponse(stats, "year"));
    }

    @GetMapping("/range")
    public ResponseEntity<StatsResponse> getStatsForRange(@Valid @RequestBody DateRangeRequest request) {
        var dateRange = new DateRange(request.getStartDate(), request.getEndDate());
        var stats = statsService.getStatsForRange(dateRange);
        log.info("Get stats for range:{}-{}: stats:{}", request.getStartDate(), request.getEndDate(), stats);
        return ResponseEntity.ok(mapToResponse(stats, "custom"));
    }

    @GetMapping("/range/daily")
    public ResponseEntity<List<StatsResponse>> getDailyStatsForRange(@Valid @RequestBody DateRangeRequest request) {
        var dateRange = new DateRange(request.getStartDate(), request.getEndDate());
        var dailyStats = statsService.getDailyStatsForRange(dateRange);
        log.info("Get daily stats for range:{}-{}: stats:{}", request.getStartDate(), request.getEndDate(), dailyStats);
        var response = dailyStats.stream()
                .map(stats -> mapToResponse(stats, "daily"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    private StatsResponse mapToResponse(Stats stats, String period) {
        return new StatsResponse(stats.totalVotes(), stats.hangoverCount(), stats.getHangoverPercentage(), stats.date(), period);
    }
}