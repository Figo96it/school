package pl.sda.reports;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sda.eksporter.PdfDocument;
import pl.sda.mocks.MockDataResolver;
import pl.sda.model.Student;
import pl.sda.model.StudentGrade;
import pl.sda.repository.GradeRepository;
import pl.sda.repository.StudentGradeRepository;
import pl.sda.repository.StudentRepository;
import pl.sda.tool.GeneralFunctions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportGenerator {

    private PdfDocument pdfDocument;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentGradeRepository studentGradeRepository;
    @Autowired
    private StudentRepository studentRepository;

    private Integer count = 0;

    public void generateBestGradesReportFromYear(Integer year) {
        List<StudentGrade> allStudentGrades = MockDataResolver.getStudentGradeList();

        List<Pair<Student, Double>> top100Students = GeneralFunctions.returnTopStudentsWithGradesAverageByYear(allStudentGrades, year, 10);
        pdfDocument = new PdfDocument(top100Students.stream().map(pair -> new ReportStudentDto(pair.getKey(), pair.getValue())).collect(Collectors.toList()), ".");
        pdfDocument.generateWith("10 of the best Students of year " + year, "This is the list of our best students that we ever had.\n" +
                "We are almost proud of their accomplishments.\n");
    }

    // Beginning of every minute
    @Scheduled(cron = "1 * * * * *")
    public void generateBestGradesReportEver() {
        // TODO: SWITCH TO PROPER REPOSITORY!!!
        List<StudentGrade> allStudentGrades = MockDataResolver.getStudentGradeList();

        System.out.println(LocalDateTime.now().toString() + ": CREATING REPORT!");
        List<Pair<Student, Double>> top100Students = GeneralFunctions.returnTopStudentsWithGradesAverage(allStudentGrades, 10);
        pdfDocument = new PdfDocument(top100Students.stream().map(pair -> new ReportStudentDto(pair.getKey(), pair.getValue())).collect(Collectors.toList()), ".");
        pdfDocument.generateWith("10 of the best Students EVER", "This is the list of our best students that we ever had.\n" +
                "We are very proud of their accomplishments.\n");
    }
}
