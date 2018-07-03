package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Classroom;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class ClassroomManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public Classroom create() {
        return null;
    }

    public Classroom delete() {
        return null;
    }

    public Classroom edit() {
        return null;
    }

    public List<Classroom> findAll() {
        return null;
    }

    public Classroom find(Integer id) {
        return null;
    }
    public Classroom findClassroomByClassName(String className) {
        return null;
    }
}
