import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.XlsReader;
import model.Student;
import model.University;
import util.ComparatorUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Boot {


    public static void main(String[] args) throws IOException {

        String filePath = "K:\\IdeaProjects\\MyEducation\\Module 26 Application_design_SOLID_and_beyond\\SF_Mod260901_Project\\src\\main\\resources\\universityInfo.xlsx";
        List<model.University> universities = XlsReader.readXlsUniversities(filePath);
        List<model.Student> students = XlsReader.readXlsStudents(filePath);

        /*вывод использованием цикла и до сортировки.*/
        for (University u :
                universities) {
            System.out.println(u);
        }
        for (Student s :
                students) {
            System.out.println(s);
        }

        /*Вывести университет опредедленного студента.*/
/*
        Student studentForPrintUniversity = students.get(3);
        System.out.println("\n" + "Вывести университет студента " + studentForPrintUniversity.getFullName());
        for (University u :
                universities) {
            if (u.getId().equals(studentForPrintUniversity.getUniversityId())) {
                System.out.println(u);
            }
        }
*/
        /*создание нужных компараторов для сортировки*/
        Comparator<University> universityComparator = ComparatorUtil.getComparator(UniversityComparatorType.YEAR);
        Comparator<Student> studentComparator = ComparatorUtil.getComparator(StudentComparatorType.AVG_EXAM_SCORE);

        System.out.println();
        /*вывод использованием Stream API и после сортировки.*/
        universities.stream().
                sorted(universityComparator).
                forEach(System.out::println);
        students.stream().
                sorted(studentComparator).
                forEach(System.out::println);
    }
}