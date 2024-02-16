package com.example.cinemaroomrestservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CinemaRoomRestServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testGetSeatsInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/seats"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rows").value(9))
                .andExpect(MockMvcResultMatchers.jsonPath("$.columns").value(9))
                .andExpect(MockMvcResultMatchers.jsonPath("$.seats.length()").value(81));
    }
}
