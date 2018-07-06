package pl.sda.reports;

import com.itextpdf.text.DocumentException;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sda.eksporter.PdfDocument;
import pl.sda.model.Student;
import pl.sda.model.StudentGrade;
import pl.sda.repository.StudentGradeRepository;
import pl.sda.tool.GeneralFunctions;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class ReportGenerator {

    private PdfDocument pdfDocument;
    private StudentGradeRepository studentGradeRepository;
    private static final Logger logger = getLogger(ReportGenerator.class);

    @Autowired
    public ReportGenerator(StudentGradeRepository studentGradeRepository) {
        this.studentGradeRepository = studentGradeRepository;
    }

    public void generateBestGradesReportFromYear(Integer year) {
        List<StudentGrade> allStudentGrades = studentGradeRepository.findAll();
        List<Pair<Student, Double>> top100Students = GeneralFunctions.returnTopStudentsWithGradesAverageByYear(allStudentGrades, year, 10);

        logger.info(LocalDateTime.now().toString() + ": CREATING BestGradesReportFromYear REPORT!");
        try {
            pdfDocument = new PdfDocument(top100Students.stream().map(pair -> new ReportStudentDto(pair.getKey(), pair.getValue())).collect(Collectors.toList()), ".");
            pdfDocument.generateWith("10 of the best Students of year " + year, "This is the list of our best students that we ever had.\n" +
                    "We are almost proud of their accomplishments.\n");
        } catch (DocumentException | FileNotFoundException e) {
            logger.warn(e.getMessage());
        }
    }

    @Scheduled(cron = "${reportInterval}")
    public void generateBestGradesReportEver() {
        List<StudentGrade> allStudentGrades = studentGradeRepository.findAll();
        List<Pair<Student, Double>> top100Students = GeneralFunctions.returnTopStudentsWithGradesAverage(allStudentGrades, 10);

        logger.info(LocalDateTime.now().toString() + ": CREATING BestGradesReportEver REPORT!");
        try {
            pdfDocument = new PdfDocument(top100Students.stream().map(pair -> new ReportStudentDto(pair.getKey(), pair.getValue())).collect(Collectors.toList()), ".");
            pdfDocument.generateWith("10 of the best Students EVER", "This is the list of our best students that we ever had.\n" +
                    "We are very proud of their accomplishments.\n");
        } catch (DocumentException | FileNotFoundException e) {
            logger.warn(e.getMessage());
        }
    }

    @Scheduled(cron = "${reportInterval}")
    public void generateSubjectAveragesReport() {
        List<StudentGrade> allStudentGrades = studentGradeRepository.findAll();
        Map<Student, Map<String, Double>> studentsWithSubjectsAverages = GeneralFunctions.getStudentsWithSubjectsAveragesFrom(allStudentGrades);

        logger.info(LocalDateTime.now().toString() + ": CREATING SubjectAveragesReport REPORT!");

        pdfDocument = new PdfDocument(".");
        try {
            pdfDocument.generateStudentsSubjectAveraragesReport(studentsWithSubjectsAverages);
        } catch (DocumentException | FileNotFoundException e) {
            logger.warn(e.getMessage());
        }
    }
}
