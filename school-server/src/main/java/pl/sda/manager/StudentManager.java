package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Student;
import pl.sda.repository.StudentRepository;

import java.util.List;

@Component
public class StudentManager {
    @Autowired
    StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    public Student edit(Student student) {
        return studentRepository.save(student);
    }

    public Student find(Integer id) {
        return studentRepository.findOne(id);
    }

    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }
}
