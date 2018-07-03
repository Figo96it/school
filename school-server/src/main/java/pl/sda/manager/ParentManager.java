package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Parent;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class ParentManager {

    private static final Logger logger = getLogger(SchoolController.class);

    public Parent create() {
        return null;
    }

    public Parent delete() {
        return null;
    }

    public Parent edit() {
        return null;
    }

    public Parent find(Integer id) {
        return null;
    }

    public List<Parent> findAll() {
        return null;
    }

    public List<Parent> findParentByFirstName(String firstName) {
        return null;
    }

    public List<Parent> findParentByLastName(String surname) {
        return null;
    }

}
