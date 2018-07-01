package pl.sda.api;

import pl.sda.model.Grade;

import java.util.List;

public interface GradeApi {

    Grade create(Grade grade);

    Integer delete(Integer id);

    Grade edit(Grade grade);

    Grade find(Integer id);

    List<Grade> findAll();
}
