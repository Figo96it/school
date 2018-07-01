package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Classroom;
import pl.sda.repository.ClassroomRepository;

import java.util.List;

@Component
public class ClassroomManager {
    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom create(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void delete(Integer id) {
        classroomRepository.delete(id);
    }

    public Classroom edit(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public List<Classroom> findAll() {
        return (List<Classroom>) classroomRepository.findAll();
    }

    public Classroom find(Integer id) {
        return classroomRepository.findOne(id);
    }
}
