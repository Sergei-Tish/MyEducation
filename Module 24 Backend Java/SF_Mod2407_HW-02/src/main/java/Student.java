public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

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
    public String toString() {
        return this.getFullName()
                + " "
                + " cтудент " + this.getCurrentCourseNumber()
                + " курса " + this.getUniversityId()
                + "университета."
                + " Средний бал " + this.getAvgExamScore()
                ;
    }
}
