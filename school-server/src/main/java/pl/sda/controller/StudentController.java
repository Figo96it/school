package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.StudentApi;
import pl.sda.manager.StudentManager;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class StudentController implements StudentApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private StudentManager studentManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    @PostMapping("student/create")
    public Student create() {
        return studentManager.create();
    }

    @Override
    @PostMapping("student/update")
    public Student update() {
        return studentManager.edit();
    }

    @Override
    @PostMapping("student/delete")
    public Student delete() {
        return studentManager.delete();
    }

    @Override
    @GetMapping("student/find/id/{studentId}")
    public Student find(@PathVariable Integer studentId) {
        if (mockData) {
            List<Student> students = MockDataResolver.findAllStudents();
            for (Student student : students) {
                if (student.getStudentId() == studentId) {
                    return student;
                }
            }
        } else {
            return studentManager.find(studentId);
        }
        return null;
    }

    @Override
    @GetMapping("student/findAll")
    public List<Student> findAll() {
        if (mockData) {
            return MockDataResolver.findAllStudents();
        } else {
            return studentManager.findAll();
        }
    }

    @Override
    @GetMapping("student/find/name/{firstName}")
    public List<Student> findStudentByFirstName(@PathVariable String firstName) {
        if (mockData) {
            List<Student> students = MockDataResolver.findAllStudents();
            List<Student> studentsByFirstName = new ArrayList<Student>();
            for (Student student : students) {
                if (student.getFirstName().equals(firstName)) {
                    studentsByFirstName.add(student);
                }
            }
            return studentsByFirstName;
        } else {
            return studentManager.findStudentByFirstName(firstName);
        }
    }

    @Override
    @GetMapping("student/find/surname/{lastName}")
    public List<Student> findStudentByLastName(@PathVariable String lastName) {
        if (mockData) {
            List<Student> students = MockDataResolver.findAllStudents();
            List<Student> studentsBySurname = new ArrayList<Student>();
            for (Student student : students) {
                if (student.getLastName().equals(lastName)) {
                    studentsBySurname.add(student);
                }
            }
            return studentsBySurname;
        } else {
            return studentManager.findStudentByLastName(lastName);
        }
    }


}
