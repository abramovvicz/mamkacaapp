package pl.mamkaca.infrastructure.adapters.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    @NotBlank(message = "Device ID cannot be empty")
    private String deviceId;

    private boolean hasHangover;
}