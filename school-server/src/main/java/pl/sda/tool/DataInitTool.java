package pl.sda.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.repository.GradeRepository;
import pl.sda.repository.ParentRepository;
import pl.sda.repository.StudentRepository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Component
public class DataInitTool {

    private GradeRepository gradeRepository;
    private ParentRepository parentRepository;
    private StudentRepository studentRepository;
    private DataSource dataSource;

    @Autowired
    public DataInitTool(GradeRepository gradeRepository, ParentRepository parentRepository, StudentRepository studentRepository, DataSource dataSource) {
        this.gradeRepository = gradeRepository;
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initData() {
//        List<Student> students = MockDataResolver.findAllStudents();
//        List<Parent> parents = MockDataResolver.findAllParents();
//        List<Grade> grades = MockDataResolver.findAllGrades();
//
//        try {
//            studentRepository.save(students);
//            parentRepository.save(parents);
//            gradeRepository.save(grades);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        System.out.println(studentRepository.count());
        System.out.println(parentRepository.count());
        System.out.println(gradeRepository.count());
    }
}
