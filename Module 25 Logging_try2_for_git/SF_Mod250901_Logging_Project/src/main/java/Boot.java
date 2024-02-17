import enums.StudyProfile;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;

public class Boot {

    public static void main(String[] args) throws IOException {

        Student student = new Student();
        student.setAvgExamScore((float) 3.5)
                .setCurrentCourseNumber(3)
                .setFullName("Ivanov Ivan Ivanovich")
                .setUniversityId("0001-high");
        System.out.println(student);

        University university = new University();
        university.setId("0001-high")
                .setFullName("Some Technical University")
                .setShortName("STU")
                .setYearOfFoundation(1985)
                .setMainProfile(StudyProfile.COMPUTER_SCIENCE);
        System.out.println(university);

        String filePath = "K:\\IdeaProjects\\MyEducation\\Module 25 Logging_try2_for_git\\SF_Mod250901_Logging_Project\\src\\main\\resources\\universityInfo.xlsx";
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

        for (University u :
                universities) {
            if (u.getId().equals(students.get(0).getUniversityId())) {
                System.out.println(u);
            }
        }
    }
}