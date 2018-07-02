package pl.sda.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.ClassroomApi;
import pl.sda.manager.ClassroomManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Classroom;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class ClassroomController implements ClassroomApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private ClassroomManager classroomManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public ClassroomController(ClassroomManager classroomManager) {
        this.classroomManager = classroomManager;
    }

    @Override
    @PostMapping("classroom/create")
    public Classroom create() {
        return classroomManager.create();
    }

    @Override
    @PostMapping("classroom/delete")
    public Classroom delete() {
        return classroomManager.delete();
    }

    @Override
    @PostMapping("classroom/edit")
    public Classroom edit() {
        return classroomManager.edit();
    }

    @Override
    @GetMapping("classroom/findAll")
    public List<Classroom> findAll() {
        if(mockData){
            return MockDataResolver.findAllClassrooms();
        }else{
            return classroomManager.findAll();
        }
    }

    @Override
    @GetMapping("classroom/find")
    public Classroom find() {
        return classroomManager.find();
    }
}
