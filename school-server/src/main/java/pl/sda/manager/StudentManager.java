package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Student;
import pl.sda.repository.StudentRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
public class StudentManager {
    @Autowired
    StudentRepository studentRepository;

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

    public Student find(Integer id) {
        return studentRepository.findOne(id);
    }

    public List<Student> findAll() {
        return StreamSupport
                .stream(studentRepository.findAll().spliterator(), false).collect(toList());

    }
}
