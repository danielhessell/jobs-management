package br.com.danielhessel.jobs_management.modules.company.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhessel.jobs_management.exceptions.CompanyNotFoundException;
import br.com.danielhessel.jobs_management.modules.company.entities.JobEntity;
import br.com.danielhessel.jobs_management.modules.company.repositories.CompanyRepository;
import br.com.danielhessel.jobs_management.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity job) {
        this.companyRepository.findById(job.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });

        return this.jobRepository.save(job);
    }

}
