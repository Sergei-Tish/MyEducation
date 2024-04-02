package comparator;

import model.Student;

public class StudentCurrentCourseNumberComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        int compare = Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
        return compare;
    }
}
