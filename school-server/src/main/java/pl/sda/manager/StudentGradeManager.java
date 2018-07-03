package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.StudentGrade;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class StudentGradeManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public StudentGrade create() {
        return null;
    }

    public StudentGrade delete() {
        return null;
    }

    public StudentGrade edit() {
        return null;
    }

    public StudentGrade find() {
        return null;
    }

    public List<StudentGrade> findAll() {
        return null;
    }
}
