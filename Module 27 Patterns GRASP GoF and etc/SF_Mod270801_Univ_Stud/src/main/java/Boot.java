import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.XlsReader;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;
import util.ComparatorUtil;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.List;

public class Boot {

    public static void main(String[] args) throws IOException {

        String filePathInput = "K:\\IdeaProjects\\MyEducation\\Module 26 Application_design_SOLID_and_beyond\\SF_Mod260901_Project\\src\\main\\resources\\universityInfo.xlsx";
        String filePathOutput = "K:\\IdeaProjects\\MyEducation\\Module 26 Application_design_SOLID_and_beyond\\SF_Mod260901_Project\\src\\main\\resources\\universityStatistics.xlsx";
        List<University> universities = XlsReader.readXlsUniversities(filePathInput);
        List<Student> students = XlsReader.readXlsStudents(filePathInput);

        /* вывод использованием цикла и до сортировки. */
        for (University u :
                universities) {
            System.out.println(u);
        }
        for (Student s :
                students) {
            System.out.println(s);
        }

        /** создание нужных компараторов для сортировки */ //
        UniversityComparator universityComparator = ComparatorUtil.getComparator(UniversityComparatorType.YEAR);
        StudentComparator studentComparator = ComparatorUtil.getComparator(StudentComparatorType.AVG_EXAM_SCORE);
        universities.sort(universityComparator);
        students.sort(studentComparator);

//        /** Вывести университет опредедленного студента. */
//
//        Student studentForPrintUniversity = students.get(3);
//        System.out.println("\n" + "Вывести университет студента " + studentForPrintUniversity.getFullName());
//        for (University u :
//                universities) {
//            if (u.getId().equals(studentForPrintUniversity.getUniversityId())) {
//                System.out.println(u);
//            }
//        }
//        System.out.println();


        /** Практическая неделя 3 */
        System.out.println("\nПрактическая неделя 3 - работа с JSON:");
//      4. В методе main выполнить сериализацию коллекций 5. и после десериализацию
        String jsonUniversityList = JsonUtil.universityListToJson(universities);    // List<University> в JSON
//        System.out.println("Инфа о ВСЕХ универах в JSON - " + jsonUniversityList);                // печать JSON универов
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(jsonUniversityList);    // JSON обратно в List<University>

        String jsonStudentList = JsonUtil.studentListToJson(students);              // List<Student> в JSON
//        System.out.println("Инфа о ВСЕХ студентах в JSON - " + jsonStudentList);                  // печать JSON студентов
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(jsonStudentList);                 // JSON обратно в List<Student>

        /** 6. Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться, что десериализация выполняется корректно.*/

        /**      — Сравнил полностью - сначала выдало false поэтому переопределил equals() в классах */
        System.out.println("Лист универов до JSON и после равны? Ответ: " + universities.equals(universitiesFromJson) + universitiesFromJson.equals(universities) + ".\n" +
                "Лист студенттов до JSON и после равны? Ответ: " + students.equals(studentsFromJson) + studentsFromJson.equals(students) + ".\n"
        );

//        System.out.println("JSON-строки университетов:");
//        universities.stream()
//                .forEach(university -> {
//                    String jsonUniversity = JsonUtil.universityToJson(university);
//                    System.out.println(jsonUniversity);
//                    University universityFromJson = JsonUtil.jsonToUniversity(jsonUniversity);
//                    System.out.println(universityFromJson);
//                });
//        System.out.println("JSON-строки студентов:");
//        students.stream()
//                .forEach(student -> {
//                    String jsonStudent = JsonUtil.studentToJson(student);
//                    System.out.println(jsonStudent);
//                    Student studentFromJson = JsonUtil.jsonToStudent(jsonStudent);
//                    System.out.println(studentFromJson);
//                });
    /** 27.8. Проект */
        List<Statistics> statisticsList = StatisticsUtil.createStatisticsList(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, filePathOutput);
    }
}