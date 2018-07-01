package pl.sda.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.model.Parent;
import pl.sda.repository.ParentRepository;

import java.util.List;

@Component
public class ParentManager {
    @Autowired
    ParentRepository parentRepository;

    public Parent create(Parent parent) {
        return parentRepository.save(parent);
    }

    public void delete(Integer id) {
        parentRepository.delete(id);
    }

    public Parent edit(Parent parent) {
        return parentRepository.save(parent);
    }

    public Parent find(Integer id) {
        return parentRepository.findOne(id);
    }

    public List<Parent> findAll() {
        return (List<Parent>) parentRepository.findAll();
    }
}
