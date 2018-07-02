package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ParentApi;
import pl.sda.manager.ParentManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Parent;

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
    public Parent create() {
        return parentManager.create();
    }

    @Override
    @PostMapping("parent/delete")
    public Parent delete() {
        return parentManager.delete();
    }

    @Override
    @PostMapping("parent/edit")
    public Parent edit() {
        return parentManager.edit();
    }

    @Override
    @GetMapping("parent/find")
    public Parent find() {
        return parentManager.find();
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
}
