package pl.sda.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findRequestParam() throws Exception {
        mockMvc.perform(get("/student/find")
                .param("id", "1"))
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void findPath() throws Exception {
        mockMvc.perform(get("/student/find/1/a/b"))
                .andExpect(status()
                        .isOk());

    }

}