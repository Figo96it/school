package pl.sda.api;

import pl.sda.model.School;

import java.util.List;

public interface SchoolApi {

    School createSchool();
    School updateSchool();
    School deleteSchool();
    School findSchool();
    List<School> findAll();
}
