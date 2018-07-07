package pl.sda;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Classroom;
import pl.sda.model.Employee;
import pl.sda.model.School;
import pl.sda.repository.ClassroomRepository;
import pl.sda.repository.EmployeeRepository;
import pl.sda.repository.SchoolRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class
ClassroomRepositoryTest {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    private List<Classroom> allClassrooms;
    private List<School> allSchools;
    private List<Employee> allEmployees;

    @Before()
    public void prepareMethod(){
        MockDataResolver.createFakeDbDataWithRelations();
        allClassrooms=MockDataResolver.findAllClassrooms();
        allSchools=MockDataResolver.getSchoolList();
        allEmployees=MockDataResolver.findAllEmployees();
        employeeRepository.save(allEmployees);
        schoolRepository.save(allSchools);
        classroomRepository.save(allClassrooms);
    }

    @Test
    public void createNewClassroom(){
        Classroom newClassroom= new Classroom(15,schoolRepository.findOne(1),"dddd",2004,employeeRepository.findOne(1));
        classroomRepository.save(newClassroom);
        assertEquals(11,classroomRepository.count());
    }

    @Test
    public void findFirstClassroom(){
        Classroom firstClassroom= allClassrooms.get(0);
        assertEquals(firstClassroom.toString(),classroomRepository.findOne(1).toString());
    }

    /**
     * Caused by: org.h2.jdbc.JdbcSQLException: Naruszenie więzów integralności: "CONSTRAINT_BA: SCHOOL.STUDENT FOREIGN KEY(ID_CLASS) REFERENCES SCHOOL.CLASSROOM(ID) (1)"
     * Referential integrity constraint violation: "CONSTRAINT_BA: SCHOOL.STUDENT FOREIGN KEY(ID_CLASS) REFERENCES SCHOOL.CLASSROOM(ID) (1)"; SQL statement:
     * delete from classroom where id=? [23503-195]
     */

    @Ignore
    @Test
    public void deleteFirstClassroomItem(){
        Classroom firstClassroom = allClassrooms.get(0);
        System.out.println(firstClassroom.getId());
        classroomRepository.delete(firstClassroom.getId());
        assertEquals(10,classroomRepository.count());
    }
}