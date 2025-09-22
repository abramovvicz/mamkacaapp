package pl.mamkaca.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mamkaca.application.ports.input.StatsService;
import pl.mamkaca.application.ports.output.VoteRepository;
import pl.mamkaca.domain.DateRange;
import pl.mamkaca.domain.Stats;
import pl.mamkaca.domain.Vote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final VoteRepository voteRepository;

    @Override
    public Stats getDailyStats() {
        var today = LocalDate.now();
        return getStatsForDate(today);
    }

    @Override
    public Stats getMonthlyStats() {

        //think about that
        var today = LocalDate.now();
        var firstDayOfMonth = today.withDayOfMonth(1);

        var monthRange = new DateRange(firstDayOfMonth, today);
        return getStatsForRange(monthRange);
    }

    @Override
    public Stats getYearlyStats() {
        var today = LocalDate.now();
        var firstDayOfYear = today.withDayOfYear(1);

        var yearRange = new DateRange(firstDayOfYear, today);
        return getStatsForRange(yearRange);
    }

    @Override
    public Stats getStatsForRange(DateRange dateRange) {
        long totalVotes = voteRepository.countByDateBetween(dateRange.startDate(), dateRange.endDate());
        long hangoverCount = voteRepository.countByDateBetweenAndHasHangover(dateRange.startDate(), dateRange.endDate(), true);
        return new Stats(totalVotes, hangoverCount, null);

    }

    @Override
    public List<Stats> getDailyStatsForRange(DateRange dateRange) {
        var current = dateRange.startDate();
        List<Stats> result = new ArrayList<>();

        // Alternative implementation with one database call and memory aggregation
        List<Vote> votes = voteRepository.findByDateBetween(dateRange.startDate(), dateRange.endDate());

        // Group by date
        Map<LocalDate, List<Vote>> votesByDate = votes.stream()
                .collect(Collectors.groupingBy(Vote::date));

        while (!current.isAfter(dateRange.endDate())) {
            List<Vote> dailyVotes = votesByDate.getOrDefault(current, List.of());

            long totalVotes = dailyVotes.size();
            long hangoverCount = dailyVotes.stream()
                    .filter(Vote::hasHangover)
                    .count();

            Stats dailyStats = new Stats(totalVotes, hangoverCount, current);

            result.add(dailyStats);
            current = current.plusDays(1);
        }

        return result;
    }

    private Stats getStatsForDate(LocalDate date) {
        long totalVotes = voteRepository.countByDate(date);
        long hangoverCount = voteRepository.countByDateAndHasHangover(date, true);
        return new Stats(totalVotes, hangoverCount, date);
    }
}