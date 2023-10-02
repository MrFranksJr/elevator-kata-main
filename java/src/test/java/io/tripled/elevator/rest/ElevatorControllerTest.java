package io.tripled.elevator.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ElevatorControllerTest {

    @Autowired
    private MockMvc api;

    @Test
    void name() throws Exception {
        var result = api.perform(MockMvcRequestBuilders.get("/api/elevator"));

        result.andDo(print());
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.currentFloor").value("GROUND"));
        result.andExpect(jsonPath("$.doorsOpened").isEmpty());
        result.andExpect(jsonPath("$.floorsPassed").isEmpty());
    }
}
