package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Subject;
import pl.sda.repository.SubjectRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
public class SubjectManager {
    @Autowired
    SubjectRepository subjectRepository;

    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Integer delete(Integer id) {
        subjectRepository.delete(id);
        return id;
    }

    public Subject edit(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject find(Integer id) {
        return subjectRepository.findOne(id);
    }

    public List<Subject> findAll() {
        return StreamSupport
                .stream(subjectRepository.findAll().spliterator(), false).collect(toList());

    }
}
