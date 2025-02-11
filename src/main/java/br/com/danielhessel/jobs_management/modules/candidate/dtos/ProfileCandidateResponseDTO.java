package br.com.danielhessel.jobs_management.modules.candidate.dtos;

import java.util.UUID;

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
    private String username;
    private String name;
    private String email;
    private String description;

}
