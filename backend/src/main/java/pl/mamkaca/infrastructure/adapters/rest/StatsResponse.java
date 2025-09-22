package pl.mamkaca.infrastructure.adapters.rest;

import java.time.LocalDate;


public record StatsResponse(long totalVotes, long hangoverCount, double hangoverPercentage, LocalDate date,
                            String period) {
}