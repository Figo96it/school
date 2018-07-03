package pl.sda.api;

import pl.sda.model.StudentGrade;

import java.util.List;

public interface StudentGradeApi {

    StudentGrade create();

    StudentGrade update();

    StudentGrade delete();

    StudentGrade find();

    List<StudentGrade> findAll();
}
