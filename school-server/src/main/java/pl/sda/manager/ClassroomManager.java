package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Classroom;
import pl.sda.repository.ClassroomRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
public class ClassroomManager {
    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom create(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

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
}
