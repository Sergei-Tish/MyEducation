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


//      4. В методе main выполнить сериализацию коллекций 5. и после десериализацию
        String jsonUniversityList = JsonUtil.universityListToJson(universities);    // List<University> в JSON
        System.out.println("Инфа о ВСЕХ универах в JSON - " + jsonUniversityList);
        List<model.University> universitiesFromJson = JsonUtil.jsonToUniversityList(jsonUniversityList);    // JSON обратно в List<University>

        String jsonStudentList = JsonUtil.studentListToJson(students);              // List<Student> в JSON
        System.out.println("Инфа о ВСЕХ студентах в JSON - " + jsonStudentList);
        List<model.Student> studentsFromJson = JsonUtil.jsonToStudentList(jsonStudentList);                 // JSON обратно в List<Student>

//      6. Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться, что десериализация выполняется корректно.
//        сначала выдало false поэтому переопределил equals()
        System.out.println("Лист универов до JSON и после равны? Ответ: " + universities.equals(universitiesFromJson) + universitiesFromJson.equals(universities) + ".\n" +
                        "Лист студенттов до JSON и после равны? Ответ: " + students.equals(studentsFromJson) + studentsFromJson.equals(students) + ".\n"
        );

        System.out.println("JSON-строки университетов:");
        universities.stream()
                .forEach(university -> {
                    String jsonUniversity = JsonUtil.universityToJson(university);
                    System.out.println(jsonUniversity);
                    University universityFromJson = JsonUtil.jsonToUniversity(jsonUniversity);
                    System.out.println(universityFromJson);
                });
        System.out.println("JSON-строки студентов:");
        students.stream()
                .forEach(student -> {
                    String jsonStudent = JsonUtil.studentToJson(student);
                    System.out.println(jsonStudent);
                    Student studentFromJson = JsonUtil.jsonToStudent(jsonStudent);
                    System.out.println(studentFromJson);
                });
    }
}