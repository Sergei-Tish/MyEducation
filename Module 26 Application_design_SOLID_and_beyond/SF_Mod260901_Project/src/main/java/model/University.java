package model;

import enums.StudyProfile;

import java.util.Objects;

public class University {

    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName) {
        this(id, fullName, shortName, 0, null);
    }

    public University(String id, String fullName, String shortName, int yearsOfFoundation) {
        this(id, fullName, shortName, yearsOfFoundation, null);
    }

    public University(String id, String fullName, String shortName, StudyProfile mainProfile) {
        this(id, fullName, shortName, 0, mainProfile);
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return String.format("id = %s, fullName = %s, shortName = %s, yearOfFoundation = %s, mainProfile = %s",
                this.id,
                this.fullName,
                this.shortName,
                this.yearOfFoundation,
                this.mainProfile.getProfileName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University university = (University) o;
        return yearOfFoundation == university.yearOfFoundation &&
                Objects.equals(id, university.id) &&
                Objects.equals(fullName, university.fullName) &&
                Objects.equals(shortName, university.shortName) &&
                Objects.equals(mainProfile, university.mainProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, shortName, yearOfFoundation, mainProfile);
    }


}