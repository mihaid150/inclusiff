package org.project.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingRegisterRequest {
    @NotNull
    private UUID userExternalId;
    @NotNull
    private UUID trainingExternalId;
}
