package pl.mamkaca.infrastructure.adapters.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteResponse {
    private boolean success;
    private String message;
    private LocalDate date;
    private boolean hasHangover;
}