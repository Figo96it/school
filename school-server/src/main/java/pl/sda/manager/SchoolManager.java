package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.School;
import pl.sda.repository.SchoolRepository;

import java.util.List;

@Component
public class SchoolManager {
    @Autowired
    SchoolRepository schoolRepository;

    public School create(School school) {
        return schoolRepository.save(school);
    }

    public void delete(Integer id) {
        schoolRepository.delete(id);
    }

    public School edit(School school) {
        return schoolRepository.save(school);
    }

    public School find(Integer id) {
        return schoolRepository.findOne(id);
    }

    public List<School> findAll() {
        return (List<School>) schoolRepository.findAll();
    }
}
