package pl.sda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.model.*;
import pl.sda.repository.TestRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ModelAndDatabaseTests {

    @Autowired
    TestRepository testRepository;

    @Test
    public void addClassObjectToDatabase_whenSaveAndFound_thenOK(){
        Subject subject = new Subject(1,"Matematyka",new Plan());
        testRepository.save(subject);

        Subject foundSubject = testRepository.findOne(1);

        assertNotNull(foundSubject);
        assertEquals(foundSubject.getId(), subject.getId());
    }


//    @Test
//    public void addClassObjectToDatabase_whenSaveAndFound_thenOK(){
//        Class aClass = new Class(1,new School(),"A3",new Date(), new Employee());
//        testRepository.save(aClass);
//
//        Class foundClass = testRepository.findOne(1);
//
//        assertNotNull(foundClass);
//        assertEquals(foundClass.getId(), aClass.getId());
//    }

//    @Test
//    public void addEmployeeObjectToDatabase_whenSaveAndFound_thenOK(){
//        Employee employee = new Employee(1,"Anna", "Lewandowska", "Nauczyciel mianowany", new Class());
//        testRepository.save(employee);
//
//        Employee foundEmployee = testRepository.findOne(1);
//
//        assertNotNull(employee);
//        assertEquals(employee.getId(), foundEmployee.getId());
//    }


//    @Test
//    public void addGradeObjectToDatabase_whenSaveAndFound_thenOK(){
//        Grade grade = new Grade(1,new Subject(),new StudentGrade(),5 );
//        testRepository.save(grade);
//
//        Grade foundGrade = testRepository.findOne(1);
//
//        assertNotNull(foundGrade);
//        assertEquals(foundGrade.getId(), grade.getId());
//    }

//    @Test
//    public void addParentObjectToDatabase_whenSaveAndFound_thenOK(){
//        Parent parent = new Parent(1,"Anna", "Rybacka",new Student(),  "89798789798" , "09890809" ,"anna@rybacka@wp.pl" );
//        testRepository.save(parent);
//
//        Parent foundparent = testRepository.findOne(1);
//
//        assertNotNull(foundparent);
//        assertEquals(foundparent.getId(), parent.getId());
//    }

//    @Test
//    public void addPlanObjectToDatabase_whenSaveAndFound_thenOK(){
//        Plan plan = new Plan(1,new Class());
//        testRepository.save(plan);
//
//        Plan foundPlan = testRepository.findOne(1);
//
//        assertNotNull(foundPlan);
//        assertEquals(foundPlan.getId(), plan.getId());
//    }

//    @Test
//    public void addSchoolObjectToDatabase_whenSaveAndFound_thenOK(){
//        School school = new School(1,"Muzyczna", "Marcowa 195, Lodz, 91-000");
//        testRepository.save(school);
//
//        School foundSchool = testRepository.findOne(1);
//
//        assertNotNull(foundSchool);
//        assertEquals(foundSchool.getId(), school.getId());
//    }

//    @Test
//    public void addStudentObjectToDatabase_whenSaveAndFound_thenOK(){
//        Student student = new Student(1,new Class(),"Adam", "Rybiński" );
//        testRepository.save(student);
//
//        Student foundStudent = testRepository.findOne(1);
//
//        assertNotNull(foundStudent);
//        assertEquals(foundStudent.getStudentId(), student.getStudentId());
//    }


//    @Test
//    public void addClassObjectToDatabase_whenSaveAndFound_thenOK(){
//        StudentGrade studentGrade = new StudentGrade(1,new Student(), new Grade());
//        testRepository.save(studentGrade);
//
//        StudentGrade foundStudentGrade = testRepository.findOne(1);
//
//        assertNotNull(foundStudentGrade);
//        assertEquals(foundStudentGrade.getId(), studentGrade.getId());
//    }
}