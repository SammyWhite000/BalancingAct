package game.balancingact.backend.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import game.balancingact.backend.apicontrollers.HealthController;

/**
 * Test class for {@link HealthController}.
 * HealthControllerTest
 */
@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test to verify that the health endpoint returns a status of "ok".
     * @throws Exception
     */
    @Test
    void healthEndpointReturnsOk() throws Exception {
        // Perform a GET request to the /api/health endpoint and verify the response
        mockMvc.perform(get("/api/health"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("ok"));
    }
}