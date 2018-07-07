package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ParentApi;
import pl.sda.manager.ParentManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Parent;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class ParentController implements ParentApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private ParentManager parentManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public ParentController(ParentManager parentManager) {
        this.parentManager = parentManager;
    }

    @Override
    @PostMapping("parent/create")
    public Parent create(Parent parent) {
        return parentManager.create(parent);
    }

    @Override
    @PostMapping("parent/delete")
    public Integer delete(Integer id) {
         parentManager.delete(id);
         return id;
    }

    @Override
    @PostMapping("parent/edit")
    public Parent edit(Parent parent) {
        return parentManager.edit(parent);
    }

    @Override
    @GetMapping("parent/find/id/{id}")
    public Parent find(@PathVariable Integer id) {
        if (mockData) {
            List<Parent> parents = MockDataResolver.findAllParents();
            for (Parent parent : parents) {
                if (parent.getId() == id) {
                    return parent;
                }
            }
        } else {
            return parentManager.find(id);
        }
        return parentManager.find(id);
    }

    @Override
    @GetMapping("parent/findAll")
    public List<Parent> findAll() {
        if(mockData){
            return MockDataResolver.findAllParents();
        }else{
            return parentManager.findAll();
        }
    }

    @Override
    @GetMapping("parent/find/name/{firstName}")
    public List<Parent> findParentByFirstName(@PathVariable String firstName) {
        if (mockData) {
            List<Parent> parents = MockDataResolver.findAllParents();
            List<Parent> parentsByFirstName = new ArrayList<Parent>();
            for (Parent parent : parents) {
                if (parent.getFirstName().equals(firstName)) {
                    parentsByFirstName.add(parent);
                }
            }
            return parentsByFirstName;
        } else {
            return parentManager.findParentByFirstName(firstName);
        }
    }

    @Override
    @GetMapping("parent/find/surname/{surname}")
    public List<Parent> findParentByLastName(@PathVariable String surname) {
        if (mockData) {
            List<Parent> parents = MockDataResolver.findAllParents();
            List<Parent> parentsBySurname = new ArrayList<Parent>();
            for (Parent parent : parents) {
                if (parent.getSurname().equals(surname)) {
                    parentsBySurname.add(parent);
                }
            }
            return parentsBySurname;
        } else {
            return parentManager.findParentByLastName(surname);
        }
    }
}
