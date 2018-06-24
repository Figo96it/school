package pl.sda.api;

import pl.sda.model.School;

import java.util.List;

public interface SchoolApi {

    School create();

    School update();

    School delete();

    School find();

    List<School> findAll();
}
