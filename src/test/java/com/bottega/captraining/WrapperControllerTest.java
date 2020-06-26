package com.bottega.captraining;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class WrapperControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void doPost() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/do")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"street\":\"ss\", \"city\":\"ddd\"}"));

        mockMvc.perform(MockMvcRequestBuilders.post("/do")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"street\":\"ss\", \"city\":\"ddd\"}"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void doPostValidation() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/do")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"street\":\"ss\", \"city\":\"ddd\"}"));

        mockMvc.perform(MockMvcRequestBuilders.post("/do")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"street\":\"ss\", \"city\":\"ddd\"}"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
