package pl.mamkaca.domain;

import java.time.LocalDate;


public record Vote(
        String id,
        String deviceHash,
        LocalDate date,
        boolean hasHangover,
        Long createdAt) {
}