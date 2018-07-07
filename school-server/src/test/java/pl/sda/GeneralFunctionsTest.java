package pl.sda;


import org.junit.Before;
import org.junit.Test;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Student;
import pl.sda.model.StudentGrade;
import pl.sda.tool.GeneralFunctions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class GeneralFunctionsTest {

    @Before
    public void generateData() {
        MockDataResolver.createFakeDbDataWithRelations();
    }


    @Test
    public void testAveragesAreOk() {
        List<StudentGrade> allStudentGrades = MockDataResolver.getStudentGradeList();

        Map<Integer, Map<String, Double>> treeMapIdStudentAverageBySubject = GeneralFunctions.createTreeMapIdStudentAverageBySubject(allStudentGrades);
        StudentGrade studentGrade = allStudentGrades.get(0);
        String subjectName = studentGrade.getGrade().getSubject().getSubjectName();
        Student student = studentGrade.getStudent();
        Integer studentId = student.getStudentId();
        Map<String, Double> subjectsAveragesMap = treeMapIdStudentAverageBySubject.get(studentId);
        Double average = subjectsAveragesMap.get(subjectName);

        List<Integer> grades = allStudentGrades.stream()
                .filter(sg -> sg.getStudent().equals(student) && sg.getGrade().getSubject().getSubjectName().equalsIgnoreCase(subjectName))
                .map(sg -> sg.getGrade().getGrade()).collect(Collectors.toList());

        assertEquals(average, calculateMeanFrom(grades));

    }

    private static Double calculateMeanFrom(List<Integer> grades) {
        return grades.stream().mapToDouble(value -> value).average().orElse(0.0);
    }

}
