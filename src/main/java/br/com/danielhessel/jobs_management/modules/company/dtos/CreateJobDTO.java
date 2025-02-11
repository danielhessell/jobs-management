package br.com.danielhessel.jobs_management.modules.company.dtos;

import lombok.Data;

@Data
public class CreateJobDTO {
    
    private String description;
    private String benefits;
    private String level;

}
