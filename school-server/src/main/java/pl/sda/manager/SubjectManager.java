package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Subject;
import pl.sda.repository.SubjectRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class SubjectManager {
    @Autowired
    SubjectRepository subjectRepository;

    private static final Logger logger = getLogger(SchoolController.class);

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

    public Subject findSubjectByNameSubject(String subjectName) {
        return null;
    }
}
