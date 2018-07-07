package pl.sda.controller;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Classroom create(Classroom classroom) {
        return classroomManager.create(classroom);
    }

    @Override
    @PostMapping("classroom/delete")
    public Integer delete(Integer id) {
        classroomManager.delete(id);
        return id;
    }

    @Override
    @PostMapping("classroom/edit")
    public Classroom edit(Classroom classroom) {
        return classroomManager.edit(classroom);
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
    @GetMapping("classroom/find/id/{id}")
    public Classroom find(@PathVariable Integer id) {
        if (mockData) {
            List<Classroom> classrooms = MockDataResolver.findAllClassrooms();
            for (Classroom classroom : classrooms) {
                if (classroom.getId() == id) {
                    return classroom;
                }
            }
        } else {
            return classroomManager.find(id);
        }
        return classroomManager.find(id);
    }

    @Override
    @GetMapping("classroom/find/name/{className}")
    public Classroom findClassroomByClassName(@PathVariable String className) {
        if (mockData) {
            List<Classroom> classrooms = MockDataResolver.findAllClassrooms();
            for (Classroom classroom : classrooms) {
                if (classroom.getClassName().equals(className)) {
                    return classroom;
                }
            }
        } else {
            return classroomManager.findClassroomByClassName(className);
        }
        return null;
    }

}
