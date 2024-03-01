package model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Student {
    @SerializedName("Имя студента")
    private String fullName;
    @SerializedName("ID-университета")
    private String universityId;
    @SerializedName("Курс обучения")
    private int currentCourseNumber;
    @SerializedName("Средняя оценка")
    private float avgExamScore;

    public Student() {
        this("неуказано", "неуказано", 0, 0.0f);
    }

    public Student(String fullName) {
        this(fullName, "неуказано", 0, 0.0f);
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

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
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
        Student student = (Student) obj;
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