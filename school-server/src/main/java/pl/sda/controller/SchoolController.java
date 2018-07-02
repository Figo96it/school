package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.SchoolApi;
import pl.sda.manager.SchoolManager;
import pl.sda.model.School;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class SchoolController implements SchoolApi {

    private static final Logger logger = getLogger(SchoolController.class);
    private SchoolManager schoolManager;

    @Value("${use.mockData}")
    private boolean mockData;

    @Autowired
    public SchoolController(SchoolManager schoolManager) {
        this.schoolManager = schoolManager;
    }

    @Override
    @PostMapping("school/create")
    public School create() {
        return schoolManager.create();
    }

    @Override
    @PostMapping("school/update")
    public School update() {
        return schoolManager.edit();
    }

    @Override
    @PostMapping("school/delete")
    public School delete() {
        return schoolManager.delete();
    }

    @Override
    @GetMapping("school/find")
    public School find() {
        return schoolManager.find();
    }

    @Override
    @GetMapping("school/findAll")
    public List<School> findAll() {
        return schoolManager.findAll();
    }
}
