package pl.sda.api;

import pl.sda.model.School;

import java.util.List;

public interface SchoolApi {

    School create(School school);

    Integer delete(Integer id);

    School edit(School school);

    School find(Integer id);

    List<School> findAll();
}
