package br.com.danielhessel.jobs_management.modules.candidate.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhessel.jobs_management.exceptions.JobNotFoundException;
import br.com.danielhessel.jobs_management.exceptions.UserNotFoundException;
import br.com.danielhessel.jobs_management.modules.candidate.CandidateRepository;
import br.com.danielhessel.jobs_management.modules.candidate.entities.ApplyJobEntity;
import br.com.danielhessel.jobs_management.modules.candidate.repositories.ApplyJobRepository;
import br.com.danielhessel.jobs_management.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID candidateId, UUID jobId) {
        this.candidateRepository.findById(candidateId).orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(jobId).orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        var applyJob = ApplyJobEntity.builder()
            .candidateId(candidateId)
            .jobId(jobId)
            .build();

        applyJob = this.applyJobRepository.save(applyJob);
        return applyJob;
    }

}
