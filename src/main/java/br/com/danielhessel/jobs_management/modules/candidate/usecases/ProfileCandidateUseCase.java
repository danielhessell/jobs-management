package br.com.danielhessel.jobs_management.modules.candidate.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhessel.jobs_management.exceptions.UserNotFoundException;
import br.com.danielhessel.jobs_management.modules.candidate.CandidateRepository;
import br.com.danielhessel.jobs_management.modules.candidate.dtos.ProfileCandidateResponseDTO;

@Service
public class ProfileCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID candidateId) {
        var candidate = this.candidateRepository.findById(candidateId).orElseThrow(() -> {
            throw new UserNotFoundException();
        });
        
        var profileCandidateResponseDTO = ProfileCandidateResponseDTO.builder()
            .id(candidateId)
            .username(candidate.getUsername())
            .name(candidate.getName())
            .email(candidate.getEmail())
            .description(candidate.getDescription())
            .build();

        return profileCandidateResponseDTO;
    }

}
