package pl.sda.api;

import pl.sda.model.Grade;

import java.util.List;

public interface GradeApi {

    Grade createGrade();
    Grade updateGrade();
    Grade deleteGrade();
    Grade findGrade();
    List<Grade> findAll();
}
