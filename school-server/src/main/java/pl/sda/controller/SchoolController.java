package pl.sda.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.api.SchoolApi;
import pl.sda.manager.SchoolManager;
import pl.sda.mocks.MockDataResolver;
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
    public School create(School school) {
        return schoolManager.create(school);
    }

    @Override
    @PostMapping("school/update")
    public School edit(School school) {
        return schoolManager.edit(school);
    }

    @Override
    @PostMapping("school/delete")
    public Integer delete(Integer id) {
        schoolManager.delete(id);
        return id;
    }

    @Override
    @GetMapping("school/find")
    public School find(Integer id) {
        return schoolManager.find(id);
    }

    @Override
    @GetMapping("school/findAll")
    public List<School> findAll() {
        if(mockData){
            return MockDataResolver.getSchoolsList();
        }else{
            return schoolManager.findAll();
        }
    }
}
