package br.com.danielhessel.jobs_management.modules.company.controllers;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.danielhessel.jobs_management.modules.company.dtos.CreateJobDTO;
import br.com.danielhessel.jobs_management.modules.company.entities.CompanyEntity;
import br.com.danielhessel.jobs_management.modules.company.repositories.CompanyRepository;
import br.com.danielhessel.jobs_management.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CreateJobControllerTest {
    
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CompanyRepository companyRepository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
    }

    @Test
    public void should_be_able_to_create_a_new_job() throws Exception {
        var company = CompanyEntity.builder()
            .name("Company Name")
            .email("company@example.com")
            .password("1234567890")
            .username("companyname")
            .description("Company description")
            .build();
        
        company = companyRepository.saveAndFlush(company);

        var createJobDTO = CreateJobDTO.builder()
            .benefits("Benefícios teste")
            .description("Job description test")
            .level("TESTE")
            .build();

        mvc.perform(
            MockMvcRequestBuilders.post("/companies/jobs/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectToJSON(createJobDTO))
                .header("Authorization", TestUtils.generateCompanyToken(company.getId(), "jobs_management_secret_hash"))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_not_be_able_to_create_a_new_job_if_company_not_found() throws Exception {
        var createJobDTO = CreateJobDTO.builder()
        .benefits("Benefícios teste")
        .description("Job description test")
        .level("TESTE")
        .build();

        mvc.perform(
            MockMvcRequestBuilders.post("/companies/jobs/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectToJSON(createJobDTO))
                .header("Authorization", TestUtils.generateCompanyToken(UUID.randomUUID(), "jobs_management_secret_hash"))
        ).andExpect(MockMvcResultMatchers.status().is(400));
    }

}
