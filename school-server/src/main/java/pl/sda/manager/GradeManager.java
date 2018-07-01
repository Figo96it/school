package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Grade;
import pl.sda.repository.GradeRepository;

import java.util.List;

@Component
public class GradeManager {
    @Autowired
    GradeRepository gradeRepository;

    public Grade create(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void delete(Integer id) {
        gradeRepository.delete(id);
    }

    public Grade edit(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade find(Integer id) {
        return gradeRepository.findOne(id);
    }

    public List<Grade> findAll() {
        return (List<Grade>) gradeRepository.findAll();
    }
}
