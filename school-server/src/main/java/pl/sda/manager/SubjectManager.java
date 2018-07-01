package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Subject;
import pl.sda.repository.SubjectRepository;

import java.util.List;

@Component
public class SubjectManager {
    @Autowired
    SubjectRepository subjectRepository;

    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void delete(Integer id) {
        subjectRepository.delete(id);
    }

    public Subject edit(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject find(Integer id) {
        return subjectRepository.findOne(id);
    }

    public List<Subject> findAll() {
        return (List<Subject>) subjectRepository.findAll();
    }
}
