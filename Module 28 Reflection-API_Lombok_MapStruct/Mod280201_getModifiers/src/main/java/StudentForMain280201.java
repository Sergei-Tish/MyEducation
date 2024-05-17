import java.util.Objects;

public class StudentForMain280201 {
    private int size;
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    //        @SerializedName("Имя студента")
    private String fullName;
    //        @SerializedName("ID-университета")
    private String universityId;
    //        @SerializedName("Курс обучения")
    private int currentCourseNumber;
    //        @SerializedName("Средняя оценка")
    private float avgExamScore;

    public StudentForMain280201() {
        this("неуказано", "неуказано", 0, 0.0f);
    }

    public StudentForMain280201(String fullName) {
        this(fullName, "неуказано", 0, 0.0f);
    }

    public StudentForMain280201(String fullName, String universityId) {
        this(fullName, universityId, 0, 0.0f);
    }

    public StudentForMain280201(String fullName, String universityId, int currentCourseNumber) {
        this(fullName, universityId, currentCourseNumber, 0.0f);
    }

    public StudentForMain280201(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public StudentForMain280201 setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public StudentForMain280201 setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public StudentForMain280201 setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public StudentForMain280201 setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return String.format("fullName = %s, universityId = %s, currentCourseNumber = %s, avgExamScore = %s",
                this.fullName,
                this.universityId,
                this.currentCourseNumber,
                this.avgExamScore);
    }

    /* Практическая неделя 3 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StudentForMain280201 student = (StudentForMain280201) obj;
        return currentCourseNumber == student.currentCourseNumber &&
                Float.compare(student.avgExamScore, avgExamScore) == 0 &&
                Objects.equals(fullName, student.fullName) &&
                Objects.equals(universityId, student.universityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, universityId, currentCourseNumber, avgExamScore);
    }

}
