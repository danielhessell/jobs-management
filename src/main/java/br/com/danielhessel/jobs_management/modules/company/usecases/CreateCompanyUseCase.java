package br.com.danielhessel.jobs_management.modules.company.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.danielhessel.jobs_management.exceptions.UserFoundException;
import br.com.danielhessel.jobs_management.modules.company.entities.CompanyEntity;
import br.com.danielhessel.jobs_management.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity company) {
        this.companyRepository
            .findByUsernameOrEmail(company.getUsername(), company.getEmail())
            .ifPresent((comp) -> {
                throw new UserFoundException();
            });

        var password = passwordEncoder.encode(company.getPassword());
        company.setPassword(password);

        return this.companyRepository.save(company);
    }

}
