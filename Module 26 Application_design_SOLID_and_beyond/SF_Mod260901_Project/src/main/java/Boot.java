import comparator.StudentComparator;
import comparator.UniversityComparator;
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

        for (University u :
                universities) {
            System.out.println(u);
        }
        for (Student s :
                students) {
            System.out.println(s);
        }

        Student studentForPrintUniversity = students.get(3);
        System.out.println("\n" + "Вывести университет студента " + studentForPrintUniversity.getFullName());
        for (University u :
                universities) {
            if (u.getId().equals(studentForPrintUniversity.getUniversityId())) {
                System.out.println(u);
            }
        }

        System.out.println();

        /* В методе main реализовать получение компаратора по типу (вызов метода утилитного класса).
         * Сохранить полученные значения (то есть экземпляры компараторов) в переменные с типом интерфейса компаратора
         * (аналогично тому, как в коллекциях делается List<T> someList = new ArrayList()).
         */
        StudentComparator studentComparator = ComparatorUtil.getComparator(StudentComparatorType.COURSE);
        Comparator<Student> studentComparator2 = ComparatorUtil.getComparator(StudentComparatorType.COURSE);

        UniversityComparator universityComparator = ComparatorUtil.getComparator(UniversityComparatorType.PROFILE);
        Comparator<University> universityComparator1 = ComparatorUtil.getComparator(UniversityComparatorType.PROFILE);

        System.out.println();
    }
}