package br.com.danielhessel.jobs_management.modules.company.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhessel.jobs_management.modules.company.entities.JobEntity;
import br.com.danielhessel.jobs_management.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity job) {
        return this.jobRepository.save(job);
    }

}
