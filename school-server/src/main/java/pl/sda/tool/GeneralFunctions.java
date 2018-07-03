package pl.sda.tool;

import javafx.util.Pair;
import pl.sda.model.Student;
import pl.sda.model.StudentGrade;
import pl.sda.model.Subject;

import java.util.*;
import java.util.stream.Collectors;

public class GeneralFunctions {


    public static List<Pair<Student, Double>> returnTopStudentsWithGradesAverage(List<StudentGrade> studentGrades, Integer howMany) {
        Map<Integer, Student> idStudentMap = new HashMap<>();
        createIdStudentMap(idStudentMap, studentGrades);

        return createTreeMapIdStudentAverage(studentGrades).entrySet()
                .stream()
                .limit(howMany)
                .map(entry -> new Pair<>(idStudentMap.get(entry.getKey()), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static List<Pair<Student, Double>> returnStudentsWithGradesAverage(List<StudentGrade> studentGrades) {
        Map<Integer, Student> idStudentMap = new HashMap<>();
        createIdStudentMap(idStudentMap, studentGrades);

        return createTreeMapIdStudentAverage(studentGrades).entrySet()
                .stream()
                .map(entry -> new Pair<>(idStudentMap.get(entry.getKey()), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Map<Integer, Map<String, Double>> createTreeMapIdStudentAverageBySubject(List<StudentGrade> studentGrades) {
        // id student grade
        Map<Integer, Map<String, List<Integer>>> subjectGradesPerStudentId = new HashMap<>();
        createIdSubjectGradesMap(subjectGradesPerStudentId, studentGrades);

        Map<Integer, Student> idStudentMap = new HashMap<>();
        createIdStudentMap(idStudentMap, studentGrades);

        Map<Integer, Map<String, Double>> subjectAveragePerStudentId = new HashMap<>();

        fillSubjectAveragesMapPerStudentId(subjectAveragePerStudentId, subjectGradesPerStudentId);
        return subjectAveragePerStudentId;
    }

    public static List<Pair<Student, Double>> returnTopStudentsWithGradesAverageByYear(List<StudentGrade> studentGrades, Integer year, Integer howMany) {
        Map<Integer, Student> idStudentMap = new HashMap<>();
        createIdStudentMap(idStudentMap, studentGrades);
        TreeMap<Integer, Double> treeMapIdStudentAverage = createTreeMapIdStudentAverage(studentGrades);
        List<Pair<Student, Double>> result = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : treeMapIdStudentAverage.entrySet()) {
            Student student = idStudentMap.get(entry.getKey());
            Integer studentsYear = student.getClassroom().getYear();
            if (studentsYear.equals(year)) {
                result.add(new Pair<>(student, entry.getValue()));
            }
        }
        return result;

        // STACK OVERFLOW EXCEPTION!!!!!

//        return createTreeMapIdStudentAverage(studentGrades).entrySet()
//                .stream()
//                .map(entry -> new Pair<Student, Double>(idStudentMap.get(entry.getKey()), entry.getValue()))
//                .filter(entry -> idStudentMap.get(entry.getKey()).getClassroom().getYear().equals(year))
//                .limit(howMany)
//                .collect(Collectors.toList());
    }


    private static TreeMap<Integer, Double> createTreeMapIdStudentAverage(List<StudentGrade> studentGrades) {
        // id student grade
        Map<Integer, List<Integer>> gradesPerStudentId = new HashMap<>();
        createIdGradesMap(gradesPerStudentId, studentGrades);

        Map<Integer, Student> idStudentMap = new HashMap<>();
        createIdStudentMap(idStudentMap, studentGrades);

        Map<Integer, Double> averagePerStudentId = new HashMap<>();

        fillAveragesMap(averagePerStudentId, gradesPerStudentId);

        ValueComparator bvc = new ValueComparator(averagePerStudentId);
        TreeMap<Integer, Double> sortedMap = new TreeMap<>(bvc);
        sortedMap.putAll(averagePerStudentId);
        return sortedMap;
    }


    private static void fillSubjectAveragesMapPerStudentId(Map<Integer, Map<String, Double>> subjectAveragePerStudentId, Map<Integer, Map<String, List<Integer>>> subjectGradesPerStudentId) {
        for (Map.Entry<Integer, Map<String, List<Integer>>> entry : subjectGradesPerStudentId.entrySet()) {
            Map<String, List<Integer>> subjectGradesMap = entry.getValue();
            subjectAveragePerStudentId.putIfAbsent(entry.getKey(), new HashMap<>());
            Map<String, Double> subjectAverage = subjectAveragePerStudentId.compute(entry.getKey(), (k, v) -> new HashMap<>(v));
            fillSubjectAveragesMap(subjectAverage, subjectGradesMap);
        }
    }

    private static void fillSubjectAveragesMap(Map<String, Double> subjectAverage, Map<String, List<Integer>> subjectGradesPerStudentId) {
        for (Map.Entry<String, List<Integer>> entry : subjectGradesPerStudentId.entrySet()) {
            subjectAverage.put(entry.getKey(), calculateMeanFrom(entry.getValue()));
        }
    }


    private static void createIdSubjectGradesMap(Map<Integer, Map<String, List<Integer>>> subjectGradesPerStudentId, List<StudentGrade> studentGrades) {
        for (StudentGrade studentGrade : studentGrades) {
            Subject subject = studentGrade.getGrade().getSubject();
            Integer idStudent = studentGrade.getStudent().getStudentId();
            subjectGradesPerStudentId.putIfAbsent(idStudent, new HashMap<>());
            Map<String, List<Integer>> subjectGrades = subjectGradesPerStudentId.compute(idStudent, (k, v) -> new HashMap<>(v));
            subjectGrades.putIfAbsent(subject.getSubjectName(), new LinkedList<>());
            List<Integer> gradesList = subjectGrades.compute(subject.getSubjectName(), (k, v) -> new LinkedList<>(v));
            gradesList.add(studentGrade.getGrade().getGrade());
        }
    }

    private static void createIdStudentMap(Map<Integer, Student> idStudentMap, List<StudentGrade> studentGrades) {
        for (StudentGrade studentGrade : studentGrades) {
            Integer idStudent = studentGrade.getStudent().getStudentId();
            idStudentMap.putIfAbsent(idStudent, studentGrade.getStudent());
        }
    }

    private static void fillAveragesMap(Map<Integer, Double> averagePerStudentId, Map<Integer, List<Integer>> gradesPerStudentId) {
        for (Map.Entry<Integer, List<Integer>> entry : gradesPerStudentId.entrySet()) {
            averagePerStudentId.put(entry.getKey(), calculateMeanFrom(entry.getValue()));
        }
    }

    private static void createIdGradesMap(Map<Integer, List<Integer>> gradesPerStudentId,
                                          List<StudentGrade> studentGrades) {
        for (StudentGrade studentGrade : studentGrades) {
            Integer idStudent = studentGrade.getStudent().getStudentId();
            gradesPerStudentId.putIfAbsent(idStudent, new ArrayList<>());
            List<Integer> compute = gradesPerStudentId.compute(idStudent, (k, v) -> new ArrayList<>(v));
            compute.add(studentGrade.getGrade().getGrade());
        }
    }

    private static Double calculateMeanFrom(List<Integer> grades) {
        return grades.stream().mapToDouble(value -> value).average().orElse(0.0);
    }

    static class ValueComparator implements Comparator<Integer> {

        Map<Integer, Double> base;

        ValueComparator(Map<Integer, Double> base) {
            this.base = base;
        }

        public int compare(Integer a, Integer b) {
            return base.get(a) > base.get(b) ? -1 : base.get(a).equals(base.get(b)) ? 0 : 1;
        }
    }
}
