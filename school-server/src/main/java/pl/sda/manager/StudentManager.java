package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Student;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class StudentManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public Student create() {
        return null;
    }

    public Student delete() {
        return null;
    }

    public Student edit() {
        return null;
    }

    public Student find() {
        return null;
    }

    public List<Student> findAll() {
        return null;
    }
}
