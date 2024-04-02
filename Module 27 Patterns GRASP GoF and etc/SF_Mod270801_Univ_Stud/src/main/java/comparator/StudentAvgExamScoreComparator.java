package comparator;

import model.Student;

public class StudentAvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        int compare = Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
        return compare;
    }
}
