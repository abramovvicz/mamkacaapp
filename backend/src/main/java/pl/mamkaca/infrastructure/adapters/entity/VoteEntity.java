package pl.mamkaca.infrastructure.adapters.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "votes",
       uniqueConstraints = @UniqueConstraint(name = "uk_device_date", columnNames = {"device_hash", "date"}))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_hash", nullable = false, length = 255)
    private String deviceHash;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "has_hangover", nullable = false)
    private boolean hasHangover;
}