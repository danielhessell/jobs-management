package br.com.danielhessel.jobs_management.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielhessel.jobs_management.modules.candidate.dtos.AuthCandidateRequestDTO;
import br.com.danielhessel.jobs_management.modules.candidate.usecases.AuthCandidateUseCase;

@RestController
@RequestMapping("/auth")
public class AuthCandidateController {
    
    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/candidates")
    public ResponseEntity<Object> login(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO) {
        try {
            var result = this.authCandidateUseCase.execute(authCandidateRequestDTO);
            System.out.println(result);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
