package pl.sda.api;

import pl.sda.model.Subject;

import java.util.List;

public interface SubjectApi {

    Subject create();

    Subject delete();

    Subject edit();

    Subject find();

    List<Subject> findAll();

}
