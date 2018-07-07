package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.Classroom;
import pl.sda.repository.ClassroomRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class ClassroomManager {
    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom create(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    private static final Logger logger = getLogger(SchoolController.class);

    public Integer delete(Integer id) {
        classroomRepository.delete(id);
        return id;
    }

    public Classroom edit(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom find(Integer id) {
        return classroomRepository.findOne(id);
    }

    public List<Classroom> findAll() {
        return StreamSupport
                .stream(classroomRepository.findAll().spliterator(), false).collect(toList());
    }

    public Classroom findClassroomByClassName(String className) {
        return null;
    }
}