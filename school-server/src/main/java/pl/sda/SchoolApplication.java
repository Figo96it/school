package pl.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import pl.sda.repository.*;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "pl.sda.*")
@EntityScan("pl.sda.*")
    public class SchoolApplication implements CommandLineRunner {

        private StudentRepository studentRepository;
        private GradeRepository gradeRepository;
        private ParentRepository parentRepository;
        private ClassroomRepository classroomRepository;
        private EmployeeRepository employeeRepository;
        private SchoolRepository schoolRepository;
        private SubjectRepository subjectRepository;

    @Autowired
    public SchoolApplication(StudentRepository studentRepository, GradeRepository gradeRepository, ParentRepository parentRepository, DataSource dataSource, ClassroomRepository classroomRepository, EmployeeRepository employeeRepository, SchoolRepository schoolRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
        this.parentRepository = parentRepository;
        this.classroomRepository = classroomRepository;
        this.employeeRepository = employeeRepository;
        this.schoolRepository = schoolRepository;
        this.subjectRepository = subjectRepository;
    }

    public static void main(String[] args) {
            SpringApplication.run(SchoolApplication.class, args);
        }

        @Override
        public void run(String... strings) throws Exception {
            System.out.println("INSERTED GRADES: "+gradeRepository.count());
            System.out.println("INSERTED STUDENTS: "+studentRepository.count());
            System.out.println("INSERTED PARENTS: "+parentRepository.count());
            System.out.println("INSERTED CLASSROOMS: "+classroomRepository.count());
            System.out.println("INSERTED EMPLOYEES: "+employeeRepository.count());
            System.out.println("INSERTED SCHOOLS: "+schoolRepository.count());
            System.out.println("INSERTED SUBJECTS: "+subjectRepository.count());
        }
    }

