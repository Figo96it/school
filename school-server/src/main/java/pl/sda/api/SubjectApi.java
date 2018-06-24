package pl.sda.api;

import pl.sda.model.Subject;

public interface SubjectApi {

    Subject create();

    Subject delete();

    Subject edit();

    Subject find();

    Subject findAll();

}
