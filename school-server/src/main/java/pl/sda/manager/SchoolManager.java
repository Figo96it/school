package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.School;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class SchoolManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public School create() {
        return null;
    }

    public School delete() {
        return null;
    }

    public School edit() {
        return null;
    }

    public School find() {
        return null;
    }

    public List<School> findAll() {
        return null;
    }
}
