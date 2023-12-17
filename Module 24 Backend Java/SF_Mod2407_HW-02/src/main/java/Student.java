import java.util.HashMap;
import java.util.Map;

public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    private static Map<String, String> universityData = new HashMap<>();
    public static Map<String, String> getUniversityData(String universityId) {
        return universityData;
    }
    public static void setUniversityData(Map<String, String> universityData) {
        Student.universityData = Student.getUniversityData() + universityData;
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Student(String fullName, String universityId) {
        this(fullName);
        this.universityId = universityId;
    }

    public Student(String fullName, String universityId, int currentCourseNumber) {
        this(fullName, universityId);
        this.currentCourseNumber = currentCourseNumber;
    }
    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this(fullName, universityId, currentCourseNumber);
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }



    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }



    @Override
//    public String toString() {
//        String courseInfo = (this.getCurrentCourseNumber() == 0) ? "" : " студент " + this.getCurrentCourseNumber() + " курса";
//        String universityInfo = (this.getUniversityId() == null) ? "" : " " + this.getUniversityId() + " университета";
//        String avgScoreInfo = (this.getAvgExamScore() == 0.0) ? "" : " Средний бал " + this.getAvgExamScore();
//        return this.getFullName() + courseInfo + universityInfo + "." + avgScoreInfo;
//    }

    public String toString() {
        String courseInfo = (this.getCurrentCourseNumber() == 0) ? "" : " студент " + this.getCurrentCourseNumber() + " курса";
        String universityInfo = (this.getUniversityId() == null) ? "" : " " + universityShortNameById(this.getUniversityId()) + " университета";
        String avgScoreInfo = (this.getAvgExamScore() == 0.0) ? "" : " Средний бал " + this.getAvgExamScore();
        return this.getFullName() + courseInfo + universityInfo + "." + avgScoreInfo;
    }

    private String universityShortNameById(String universityId) {
        return
        // Ваша логика получения shortName университета по его id
    }


//    public String toString() {
//        return this.getFullName()
//                + " "
//                + " cтудент " + this.getCurrentCourseNumber()
//                + " курса " + this.getUniversityId()
//                + "университета."
//                + " Средний бал " + this.getAvgExamScore()
//                ;
//    }
}
