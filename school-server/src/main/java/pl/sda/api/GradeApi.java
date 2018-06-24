package pl.sda.api;

import pl.sda.model.Grade;

import java.util.List;

public interface GradeApi {

    Grade create();
    Grade update();
    Grade delete();
    Grade find();
    List<Grade> findAll();
}
