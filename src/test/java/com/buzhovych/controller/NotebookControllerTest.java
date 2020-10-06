package com.buzhovych.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NotebookControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getAllNotebooks() throws Exception {
        this.mockMvc.perform(get("/notebooks"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getSortedByProducer() throws Exception {
        this.mockMvc.perform(get("/notebooks/sorted-descend-by-producer"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllWithMemoryMoreThan() throws Exception {
        this.mockMvc.perform(get("/notebooks/16gb-plus"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllUsed() throws Exception {
        this.mockMvc.perform(get("/notebooks/used"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}