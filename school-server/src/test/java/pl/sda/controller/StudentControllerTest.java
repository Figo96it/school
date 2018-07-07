package pl.sda.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Student;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                .param("id", "1")
                .contentType(APPLICATION_JSON))
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void findPath() throws Exception {
        mockMvc.perform(get("/student/find/1/Colton/Kelley")
                .contentType(APPLICATION_JSON))
                .andExpect(status()
                        .isOk());

    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/student/findAll")
                .contentType(APPLICATION_JSON))
                .andExpect(status()
                        .isOk());

    }

    @Test
    public void createStudent() throws Exception {
        String json = studentToJson();

        mockMvc.perform(post("/student/create")
                .content(json)
                .contentType(APPLICATION_JSON))
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void editStudent() throws Exception {
        String json = studentToJson();

        mockMvc.perform(post("/student/update")
                .content(json)
                .contentType(APPLICATION_JSON))
                .andExpect(status()
                        .isOk());
    }

    @Test
    public void deleteStudent() throws Exception {
        mockMvc.perform(post("/student/delete")
                .param("id", "10")
                .contentType(APPLICATION_JSON))
                .andExpect(status()
                        .isOk());
    }

    private String studentToJson() throws JsonProcessingException {
        Student s = MockDataResolver.findAllStudents().get(0);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(s);
    }

}