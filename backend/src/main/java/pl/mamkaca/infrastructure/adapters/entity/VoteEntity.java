package pl.mamkaca.infrastructure.adapters.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "pl")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndex(name = "device_date_idx", def = "{'deviceHash': 1, 'date': 1}", unique = true)
public class VoteEntity {
    @Id
    private String id;

    private String deviceHash;

    @Indexed
    private LocalDate date;

    private boolean hasHangover;

    private Long createdAt;
}