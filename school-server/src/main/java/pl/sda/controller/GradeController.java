package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.GradeApi;
import pl.sda.manager.GradeManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Grade;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class GradeController implements GradeApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private GradeManager gradeManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public GradeController(GradeManager gradeManager) {
        this.gradeManager = gradeManager;
    }

    @Override
    @PostMapping("grade/create")
    public Grade create() {
        return gradeManager.create();
    }

    @Override
    @PostMapping("grade/update")
    public Grade update() {
        return gradeManager.edit();
    }

    @Override
    @PostMapping("grade/delete")
    public Grade delete() {
        return gradeManager.delete();
    }

    @Override
    @GetMapping("grade/find")
    public Grade find() {
        return gradeManager.find();
    }

    @Override
    @GetMapping("grade/findAll")
    public List<Grade> findAll() {
        if(mockData){
            return MockDataResolver.findAllGrades();
        }else{
            return gradeManager.findAll();
        }
    }
}
