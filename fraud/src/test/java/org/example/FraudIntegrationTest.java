package org.example;

import org.example.fraud.FraudRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FraudIntegrationTest extends AbstractContainerBaseTest {

    @Autowired
    private FraudRepository fraudRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddFraudsters() throws Exception {
        //When
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fraud-check/fraudsters"));

        // then - verify the output
        response.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertEquals( 2, fraudRepository.findAll().size());

    }
}
