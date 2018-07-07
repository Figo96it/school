package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Student;
import pl.sda.repository.StudentRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class StudentManager {
    @Autowired
    StudentRepository studentRepository;

    private static final Logger logger = getLogger(SchoolController.class);

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Integer delete(Integer id) {
        studentRepository.delete(id);
        return id;
    }

    public Student edit(Student student) {
        return studentRepository.save(student);
    }

    public Student find(Integer studentId) {
        return studentRepository.findOne(studentId);
    }

    public List<Student> findStudentByFirstName(String firstName) {
        return null;
    }

    public List<Student> findAll() {
        return StreamSupport
                .stream(studentRepository.findAll().spliterator(), false).collect(toList());

    }

    public List<Student> findStudentByLastName(String lastName) {
        return null;
    }
}
