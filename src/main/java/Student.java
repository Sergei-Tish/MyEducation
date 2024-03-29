public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student(String fullName) {
        this(fullName, null, 0, 0.0f);
    }

    public Student(String fullName, String universityId) {
        this(fullName, universityId, 0, 0.0f);
    }

    public Student(String fullName, String universityId, int currentCourseNumber) {
        this(fullName, universityId, currentCourseNumber, 0.0f);
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId == null ? "" : universityId;
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
        String courseInfo;
        if (this.getCurrentCourseNumber() == 0) courseInfo = " студент";
        else courseInfo = " студент " + this.getCurrentCourseNumber() + " курса";

        String universityInfo;
        if (this.getUniversityId() == null || !University.universityHashMap.containsKey(this.getUniversityId())) {
            universityInfo = "";
        } else {
            universityInfo = " " + University.universityHashMap.get(this.getUniversityId()).getShortName() + "";
        }

        String avgScoreInfo = (this.getAvgExamScore() == 0.0) ? "" : " Средний бал " + this.getAvgExamScore();
        return this.getFullName() + courseInfo + universityInfo + "." + avgScoreInfo;
    }
}
