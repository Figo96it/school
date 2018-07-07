package pl.sda.api;

import pl.sda.model.Subject;

import java.util.List;

public interface SubjectApi {

    Subject create(Subject subject);

    Integer delete(Integer id);

    Subject edit(Subject subject);

    Subject find(Integer id);

    List<Subject> findAll();

    Subject find(Integer id);

    Subject findSubjectByNameSubject(String subjectName);


}
