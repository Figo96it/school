package pl.sda.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Classroom;
import pl.sda.model.School;

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

    private List<Classroom> allClassrooms;

    @Before()
    public void prepareMethod(){
       // schoolRepository.deleteAll();
        School fakeSchool = MockDataResolver.createFakeSchool();
        allClassrooms = MockDataResolver.findAllClassrooms();
        allClassrooms.forEach(classroom -> classroom.setSchool(fakeSchool));
        schoolRepository.save(fakeSchool);
        classroomRepository.save(allClassrooms);
    }

    @Test
    public void createNewClassroom(){
        assertEquals(10,classroomRepository.count());
    }

    @Test
    public void findFirstClassroom(){
        Classroom firstClassroom= allClassrooms.get(0);
        assertEquals(firstClassroom.toString(),classroomRepository.findOne(1).toString());
    }

    @Test
    public void deleteFirstClassroomItem(){
        Classroom randomClassroom = classroomRepository.findOne(2);
        classroomRepository.delete(randomClassroom);
        assertEquals(9,classroomRepository.count());
    }
}