package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.util.ArrayList;
import java.util.List;

public class StatisticsUtil {

    private StatisticsUtil() {
    }

    public static List<Statistics> createStatisticsList (List<Student> Students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

//        // неверный путь, надо через teamAPI
//        for (University university: universities) {
//            StudyProfile studyProfile = university.getMainProfile();
//            float avgExamScore = 0.0f;
//            int numberOfStudents = 0;
//            int numberOfUniversities = 0;
//            String universityNames = "";
//
//            if (containsStudyProfile(statisticsList, studyProfile)) {
//
//            }
//
//            Statistics statistics = new Statistics()
//                    .setStudyProfile(studyProfile)
//                    .setAvgExamScore(avgExamScore)
//                    .setNumberOfStudents(numberOfStudents)
//                    .setNumberOfUniversities(numberOfUniversities)
//                    .setUniversityNames(universityNames);
//            statisticsList.add(statistics);
//        }

        return statisticsList;
    }

    public static boolean containsStudyProfile(List<Statistics> statisticsList, StudyProfile studyProfileToCheck) {
        for (Statistics statistics : statisticsList) {
            if (statistics.getStudyProfile() == studyProfileToCheck) {
                return true;
            }
        }
        return false;
    }

}
