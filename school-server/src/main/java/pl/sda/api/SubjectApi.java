package pl.sda.api;

import pl.sda.model.Subject;

public interface SubjectApi {

    public Subject createSubject();
    public Subject deleteSubject();
    public Subject editSubject();
    public Subject findSubject();
    public Subject findAllSubjects();

}
