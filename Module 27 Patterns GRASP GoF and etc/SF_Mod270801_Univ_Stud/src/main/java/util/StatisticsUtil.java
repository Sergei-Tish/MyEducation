package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsUtil {

    private StatisticsUtil() {
    }

    public static List<Statistics> createStatisticsList(List<Student> students,
                                                        List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        List<StudyProfile> studyProfiles = universities.stream()
                .map(University::getMainProfile)  // список профилей
                .distinct() // уникальные профили
                .collect(Collectors.toList()); // сбор в список

        studyProfiles.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(studyProfile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .collect(Collectors.toList());

            long universitiesCount = profileUniversityIds.stream()
                    .count();
            statistics.setNumberOfUniversities((int) universitiesCount);

            String names = universities.stream()
                    .map(University::getFullName)
                    .collect(Collectors.joining("; "));
            statistics.setUniversityNames(names);

            int studentsCount = (int) students.stream()
                    .filter(student -> student.getUniversityId().equals(
                            universities.stream().
                                    filter(university -> university.getMainProfile().equals(studyProfile))
                    ))
                    .count();
            statistics.setNumberOfStudents(studentsCount);


        });




        return statisticsList;
    }

//    public static List<Statistics> createStatisticsList (List<Student> Students, List<University> universities) {
//        List<Statistics> statisticsList = new ArrayList<>();
//
//        // неверный путь, надо через StreamAPI
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
//
//        return statisticsList;
//    }
//
//    public static boolean containsStudyProfile(List<Statistics> statisticsList, StudyProfile studyProfileToCheck) {
//        for (Statistics statistics : statisticsList) {
//            if (statistics.getStudyProfile() == studyProfileToCheck) {
//                return true;
//            }
//        }
//        return false;
//    }

}



























