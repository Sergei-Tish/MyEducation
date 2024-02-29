import com.google.gson.Gson;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.XlsReader;
import model.Student;
import model.University;
import util.ComparatorUtil;
import util.JsonUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Boot {

    public static void main(String[] args) throws IOException {

        String filePath = "K:\\IdeaProjects\\MyEducation\\Module 26 Application_design_SOLID_and_beyond\\SF_Mod260901_Project\\src\\main\\resources\\universityInfo.xlsx";
        List<model.University> universities = XlsReader.readXlsUniversities(filePath);
        List<model.Student> students = XlsReader.readXlsStudents(filePath);

        /* вывод использованием цикла и до сортировки. */
        for (University u :
                universities) {
            System.out.println(u);
        }
        for (Student s :
                students) {
            System.out.println(s);
        }

//        /* Вывести университет опредедленного студента. */
//
//        Student studentForPrintUniversity = students.get(3);
//        System.out.println("\n" + "Вывести университет студента " + studentForPrintUniversity.getFullName());
//        for (University u :
//                universities) {
//            if (u.getId().equals(studentForPrintUniversity.getUniversityId())) {
//                System.out.println(u);
//            }
//        }

//        /* создание нужных компараторов для сортировки */ //
//        Comparator<University> universityComparator = ComparatorUtil.getComparator(UniversityComparatorType.YEAR);
//        Comparator<Student> studentComparator = ComparatorUtil.getComparator(StudentComparatorType.AVG_EXAM_SCORE);
//
//        System.out.println();
//        /* вывод использованием Stream API и после сортировки. */
//        universities.stream().
//                sorted(universityComparator).
//                forEach(System.out::println);
//        students.stream().
//                sorted(studentComparator).
//                forEach(System.out::println);

        /* Практическая неделя 3 */
        System.out.println("\nПрактическая неделя 3 - работа с JSON:");

        University university = universities.get(2);
        String jsonUniversity = JsonUtil.universityToJson(university);       // University в JSON
        System.out.println("Инфа об ОДНОМ универе в JSON - " + university.getShortName() + " " + jsonUniversity);
        University universityAfterJson = JsonUtil.jsonToUniversity(jsonUniversity);  // JSON обратно в University

        Student student = students.get(3);
        String jsonStudent = JsonUtil.studentToJson(student);                // Student в JSON
        System.out.println("Инфа об ОДНОМ студенте в JSON - " + student.getFullName() + " " + jsonStudent);
        Student studentAfterJson = JsonUtil.jsonToStudent(jsonStudent);              // JSON обратно в Student

        String jsonUniversityList = JsonUtil.universityListToJson(universities);    // List<University> в JSON
        System.out.println("Инфа о ВСЕХ универах в JSON - " + jsonUniversityList);
        List<model.University> universitiesAfterJson = JsonUtil.jsonToUniversityList(jsonUniversityList);    // JSON обратно в List<University>

        String jsonStudentList = JsonUtil.studentListToJson(students);              // List<Student> в JSON
        System.out.println("Инфа о ВСЕХ студентах в JSON - " + jsonStudentList);
        List<model.Student> studentsAfterJson = JsonUtil.jsonToStudentList(jsonStudentList);                 // JSON обратно в List<Student>

        System.out.println(
                "Один универ до JSON и после равны? Ответ: " + university.equals(universityAfterJson) + universityAfterJson.equals(university) + ".\n" +
                        "Один студент до JSON и после равны? Ответ: " + student.equals(studentAfterJson) + studentAfterJson.equals(student) + ".\n" +
                        "Лист универов до JSON и после равны? Ответ: " + universities.equals(universitiesAfterJson) + universitiesAfterJson.equals(universities) + ".\n" +
                        "Лист студенттов до JSON и после равны? Ответ: " + students.equals(studentsAfterJson) + studentsAfterJson.equals(students) + ".\n"
        );

        universities.stream().
                forEach(System.out::println);
        System.out.println("———————————————————————————————————————————————————————");
        universitiesAfterJson.stream().
                forEach(System.out::println); // мне выдало false поэтому сам сравнил Листы => нужно переопределить equals()
        // ещё переопредеить equals для Student
    }
}