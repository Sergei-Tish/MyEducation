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