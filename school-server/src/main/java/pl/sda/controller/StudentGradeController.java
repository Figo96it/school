package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.StudentGradeApi;
import pl.sda.manager.StudentGradeManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.StudentGrade;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class StudentGradeController implements StudentGradeApi {

    private static final Logger logger = getLogger(SchoolController.class);

    private StudentGradeManager studentGradeManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public StudentGradeController(StudentGradeManager studentGradeManager) {
        this.studentGradeManager = studentGradeManager;
    }

    @Override
    @PostMapping("student/grade/create")
    public StudentGrade create() {
        return studentGradeManager.create();
    }

    @Override
    @PostMapping("student/grade/update")
    public StudentGrade update() {
        return studentGradeManager.edit();
    }

    @Override
    @PostMapping("student/grade/delete")
    public StudentGrade delete() {
        return studentGradeManager.delete();
    }

    @Override
    @GetMapping("student/grade/find")
    public StudentGrade find() { return studentGradeManager.find(); }

    @Override
    @GetMapping("student/grade/findAll")
    public List<StudentGrade> findAll() {
        if(mockData){
            return new ArrayList<StudentGrade>();
        }else{
            return studentGradeManager.findAll();
        }
    }
}
