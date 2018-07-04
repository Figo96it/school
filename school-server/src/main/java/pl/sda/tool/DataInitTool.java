package pl.sda.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.*;
import pl.sda.repository.*;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class DataInitTool {

    private GradeRepository gradeRepository;
    private ParentRepository parentRepository;
    private StudentRepository studentRepository;
    private SchoolRepository schoolRepository;
    private ClassroomRepository classroomRepository;
    private EmployeeRepository employeeRepository;
    private SubjectRepository subjectRepository;
    private Boolean usedDataInitTool;
    private StudentGradeRepository studentGradeRepository;

    @Autowired
    public DataInitTool(GradeRepository gradeRepository,
                        ParentRepository parentRepository,
                        StudentRepository studentRepository,
                        SchoolRepository schoolRepository,
                        ClassroomRepository classroomRepository,
                        EmployeeRepository employeeRepository,
                        SubjectRepository subjectRepository,
                        StudentGradeRepository studentGradeRepository,
                        @Value("true") Boolean usedDataInitTool
//                        @Value("#{new Boolean('${useJpaMockedData}')}") Boolean usedDataInitTool
    ) {
        this.gradeRepository = gradeRepository;
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
        this.classroomRepository = classroomRepository;
        this.employeeRepository = employeeRepository;
        this.subjectRepository = subjectRepository;
        this.usedDataInitTool = usedDataInitTool;
        this.studentGradeRepository = studentGradeRepository;
    }

    @PostConstruct
    public void initData() {
    if(usedDataInitTool){
        MockDataResolver.createFakeDbDataWithRelations();
        List<School> fakeSchool = MockDataResolver.getSchoolList();
        List<Classroom> allClassrooms = MockDataResolver.findAllClassrooms();
        List<Employee> allEmployees = MockDataResolver.findAllEmployees();
        List<Grade> allGrades = MockDataResolver.findAllGrades();
        List<Parent> allParents = MockDataResolver.findAllParents();
        List<Student> allStudents = MockDataResolver.findAllStudents();
        List<Subject> allSubjects = MockDataResolver.findAllSubjects();
        List<StudentGrade> studentGradeList = MockDataResolver.getStudentGradeList();

        schoolRepository.save(fakeSchool);
        classroomRepository.save(allClassrooms);
        studentRepository.save(allStudents);
        parentRepository.save(allParents);
//        studentGradeRepository.save(studentGradeList);
//        subjectRepository.save(allSubjects);
//        gradeRepository.save(allGrades);
    }


    }
}
