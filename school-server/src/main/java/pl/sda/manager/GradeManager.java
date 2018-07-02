package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Grade;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class GradeManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public Grade create() {
        return null;
    }

    public Grade delete() {
        return null;
    }

    public Grade edit() {
        return null;
    }

    public Grade find() {
        return null;
    }

    public List<Grade> findAll() {
        return null;
    }
}
