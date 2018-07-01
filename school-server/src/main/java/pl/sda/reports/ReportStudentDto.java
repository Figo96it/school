package pl.sda.reports;

import pl.sda.model.Student;

class ReportStudentDto {

    private String studentName;
    private String className;
    private Integer year;
    private Double average;

    ReportStudentDto(Student student, Double average){
        this.className = student.getClassroom().getClassName();
        this.year = student.getClassroom().getYear();
        this.studentName = student.getFirstName() +" " + student.getLastName();
        this.average = average;
    }

}
