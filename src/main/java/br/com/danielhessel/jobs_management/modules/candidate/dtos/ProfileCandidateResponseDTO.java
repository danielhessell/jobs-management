package br.com.danielhessel.jobs_management.modules.candidate.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {
    
    private UUID id;

    @Schema(example = "johndoe")
    private String username;

    @Schema(example = "John Doe")
    private String name;

    @Schema(example = "johndoe@example.com")
    private String email;

    @Schema(example = "Desenvolvedor Back-End")
    private String description;

}
