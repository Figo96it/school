package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.School;
import pl.sda.repository.SchoolRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
public class SchoolManager {
    @Autowired
    SchoolRepository schoolRepository;

    public School create(School school) {
        return schoolRepository.save(school);
    }

    public Integer delete(Integer id) {
        schoolRepository.delete(id);
        return id;
    }

    public School edit(School school) {
        return schoolRepository.save(school);
    }

    public School find(Integer id) {
        return schoolRepository.findOne(id);
    }

    public List<School> findAll() {
        return StreamSupport
                .stream(schoolRepository.findAll().spliterator(), false).collect(toList());

    }
}
