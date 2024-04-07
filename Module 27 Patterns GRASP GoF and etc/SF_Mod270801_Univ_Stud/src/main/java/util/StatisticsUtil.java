package util;

/** 27.8. Проект */

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
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getFullName)
                    .collect(Collectors.joining("; "));
            statistics.setUniversityNames(names);

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            int studentsCount = profileStudents.size();
            statistics.setNumberOfStudents(studentsCount);

            float avgExamScore = (float) profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average()
                    .orElse(0.0);
            float roundedAvgExamScore = (float) (Math.round(avgExamScore * 100.0) / 100.0);
            statistics.setAvgExamScore(roundedAvgExamScore);
        });

        return statisticsList;
    }
}
























