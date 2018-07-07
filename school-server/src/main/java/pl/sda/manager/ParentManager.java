package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Parent;
import pl.sda.repository.ParentRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class ParentManager {
    @Autowired
    ParentRepository parentRepository;

    private static final Logger logger = getLogger(SchoolController.class);

    public Parent create(Parent parent) {
        return parentRepository.save(parent);
    }

    public Integer delete(Integer id) {
        parentRepository.delete(id);
        return id;
    }

    public Parent edit(Parent parent) {
        return parentRepository.save(parent);
    }

    public Parent find(Integer id) {
        return parentRepository.findOne(id);
    }

    public List<Parent> findAll() {
        return StreamSupport
                .stream(parentRepository.findAll().spliterator(), false).collect(toList());

    }

    public List<Parent> findParentByFirstName(String firstName) {
        return null;
    }

    public List<Parent> findParentByLastName(String surname) {
        return null;
    }

}
