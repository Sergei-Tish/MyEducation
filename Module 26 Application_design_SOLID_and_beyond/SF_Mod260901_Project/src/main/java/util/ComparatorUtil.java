package util;

import comparator.*;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;

public class ComparatorUtil {
    private ComparatorUtil() {
    }

    public static StudentComparator getComparator(StudentComparatorType studentComparatorType) {
        switch (studentComparatorType) {
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                throw new IllegalStateException("Unexpected value: " + studentComparatorType);
        }
    }

    public static UniversityComparator getComparator(UniversityComparatorType universityComparatorType) {
        switch (universityComparatorType) {
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case PROFILE:
                return new UniversityMainProfileComparator();
            case YEAR:
                return new UniversityYearOfFoundationComparator();
            default:
                throw new IllegalStateException("Unexpected value: " + universityComparatorType);
        }
    }
}

/*
public class ComparatorUtil2 {

    private static final Map<StudentComparatorType, StudentComparator> studentComparatorMap = new EnumMap<>(StudentComparatorType.class);
    private static final Map<UniversityComparatorType, UniversityComparator> universityComparatorMap = new EnumMap<>(UniversityComparatorType.class);

    static {
        studentComparatorMap.put(StudentComparatorType.UNIVERSITY_ID, new StudentUniversityIdComparator());
        studentComparatorMap.put(StudentComparatorType.FULL_NAME, new StudentFullNameComparator());
        studentComparatorMap.put(StudentComparatorType.COURSE, new StudentCurrentCourseNumberComparator());
        studentComparatorMap.put(StudentComparatorType.AVG_EXAM_SCORE, new StudentAvgExamScoreComparator());

        universityComparatorMap.put(UniversityComparatorType.ID, new UniversityIdComparator());
        universityComparatorMap.put(UniversityComparatorType.FULL_NAME, new UniversityFullNameComparator());
        universityComparatorMap.put(UniversityComparatorType.SHORT_NAME, new UniversityShortNameComparator());
        universityComparatorMap.put(UniversityComparatorType.PROFILE, new UniversityMainProfileComparator());
        universityComparatorMap.put(UniversityComparatorType.YEAR, new UniversityYearOfFoundationComparator());
    }

    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        return studentComparatorMap.get(studentComparatorType);
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        return universityComparatorMap.get(universityComparatorType);
    }
}
 */
