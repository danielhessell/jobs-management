package br.com.danielhessel.jobs_management.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielhessel.jobs_management.modules.candidate.CadidateEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
  
    @PostMapping("/")
    public void create(@Valid @RequestBody CadidateEntity candidate) {
        System.out.println("Candidato");
        System.out.println(candidate.getEmail());
    }

}
