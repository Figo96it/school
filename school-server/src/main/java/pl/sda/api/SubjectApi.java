package pl.sda.api;

import pl.sda.model.Subject;

import java.util.List;

public interface SubjectApi {

    Subject create();

    Subject delete();

    Subject edit();

    List<Subject> findAll();

    Subject find(Integer id);

    Subject findSubjectByNameSubject(String subjectName);


}
