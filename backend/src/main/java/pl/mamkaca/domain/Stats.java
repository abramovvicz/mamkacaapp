package pl.mamkaca.domain;

import java.time.LocalDate;

public record Stats(long totalVotes, long hangoverCount, LocalDate date) {
    public double getHangoverPercentage() {
        if (totalVotes == 0) {
            return 0;
        }
        return (double) hangoverCount / totalVotes * 100;
    }
}