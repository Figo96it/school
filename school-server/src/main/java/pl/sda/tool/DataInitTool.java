package pl.sda.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Grade;
import pl.sda.model.Parent;
import pl.sda.model.Student;
import pl.sda.repository.GradeRepository;
import pl.sda.repository.ParentRepository;
import pl.sda.repository.StudentRepository;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class DataInitTool {

    private GradeRepository gradeRepository;
    private ParentRepository parentRepository;
    private StudentRepository studentRepository;

    @Autowired
    public DataInitTool(GradeRepository gradeRepository, ParentRepository parentRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void initData() {
        List<Student> students = MockDataResolver.findAllStudents();
        List<Parent> parents = MockDataResolver.findAllParents();
        List<Grade> grades = MockDataResolver.findAllGrades();

        try {
            studentRepository.save(students);
            parentRepository.save(parents);
            gradeRepository.save(grades);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
