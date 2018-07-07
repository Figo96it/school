package pl.sda.manager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.controller.SchoolController;
import pl.sda.model.School;
import pl.sda.repository.SchoolRepository;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class SchoolManager {
    @Autowired
    SchoolRepository schoolRepository;

    private static final Logger logger = getLogger(SchoolController.class);

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
