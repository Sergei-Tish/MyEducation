

public class University {
    String id;
    String fullName;
    String shortName;
    int yearsOfFoundation;
    StudyProfile mainProfile;

    public University(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public University(String id, String fullName, String shortName) {
        this(id, fullName);
        this.shortName = shortName;
    }

    public University(String id, String fullName, String shortName, int yearsOfFoundation) {
        this(id, fullName, shortName);
        this.yearsOfFoundation = yearsOfFoundation;
    }

    public University(String id, String fullName, String shortName, int yearsOfFoundation, StudyProfile mainProfile) {
        this(id, fullName, shortName, yearsOfFoundation);
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearsOfFoundation() {
        return yearsOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setYearsOfFoundation(int yearsOfFoundation) {
        this.yearsOfFoundation = yearsOfFoundation;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return this.getFullName()
                + " (" + this.getShortName() + ")"
                + " основан в " + this.getYearsOfFoundation()
                + " году, направление " + this.getMainProfile()
                ;
    }
}
