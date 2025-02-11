package br.com.danielhessel.jobs_management.modules.candidate.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhessel.jobs_management.exceptions.UserFoundException;
import br.com.danielhessel.jobs_management.modules.candidate.CandidateEntity;
import br.com.danielhessel.jobs_management.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    
    @Autowired
    CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate) {
        this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()).ifPresent((cand) -> {
            throw new UserFoundException();
        });

        return this.candidateRepository.save(candidate);
    }

}
