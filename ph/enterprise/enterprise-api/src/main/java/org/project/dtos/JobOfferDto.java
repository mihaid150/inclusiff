package org.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobOfferDto {
    private UUID jobExternalId;
    private String jobDescription;
    private UUID enterpriseId;
}
