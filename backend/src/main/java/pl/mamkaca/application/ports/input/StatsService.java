package pl.mamkaca.application.ports.input;

import pl.mamkaca.domain.DateRange;
import pl.mamkaca.domain.Stats;

import java.util.List;

public interface StatsService {
    /**
     * Get statistics for today
     * @return Statistics for today
     */
    Stats getDailyStats();

    /**
     * Get statistics for the current month
     * @return Statistics for the current month
     */
    Stats getMonthlyStats();

    /**
     * Get statistics for the current year
     * @return Statistics for the current year
     */
    Stats getYearlyStats();

    /**
     * Get statistics for a specific date range
     * @param dateRange Date range to get statistics for
     * @return Statistics for the specified date range
     */
    Stats getStatsForRange(DateRange dateRange);

    /**
     * Get daily statistics for a specific date range
     * @param dateRange Date range to get statistics for
     * @return List of daily statistics for each day in the range
     */
    List<Stats> getDailyStatsForRange(DateRange dateRange);
}