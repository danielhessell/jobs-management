package br.com.danielhessel.jobs_management.modules.company.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {
    
    @Schema(example = "Vaga para pessoa desenvolvedor junior.", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Totalpass, plano de saúde, VR/VA, PLR", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "JUNIOR", requiredMode = RequiredMode.REQUIRED)
    private String level;

}
