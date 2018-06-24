package pl.sda.api;

import pl.sda.model.Class;

import java.util.List;

public interface ClassApi {

    public Class createClass();
    public Class deleteClass();
    public Class editClass();
    public List<Class> findAllClasses();
    public Class findClass();
}
