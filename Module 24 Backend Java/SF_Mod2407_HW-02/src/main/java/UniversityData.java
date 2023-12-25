public class UniversityData {
    private String id;
    private String fullName;
    private String shortName;
    private int yearsOfFoundation;
    private StudyProfile mainProfile;

    public UniversityData(String id, String fullName, String shortName) {
        this(id, fullName, shortName, 0, null);
    }

    public UniversityData(String id, String fullName, String shortName, int yearsOfFoundation) {
        this(id, fullName, shortName, yearsOfFoundation, null);
    }

    public UniversityData(String id, String fullName, String shortName, StudyProfile mainProfile) {
        this(id, fullName, shortName, 0, mainProfile);
    }

    public UniversityData(String id, String fullName, String shortName, int yearsOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearsOfFoundation = yearsOfFoundation;
        this.mainProfile = mainProfile;
        University.universityHashMap.put(id, this);
    }

    public String getId() {
        return id;
    }

    public UniversityData setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UniversityData setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public UniversityData setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearsOfFoundation() {
        return yearsOfFoundation;
    }

    public UniversityData setYearsOfFoundation(int yearsOfFoundation) {
        this.yearsOfFoundation = yearsOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public UniversityData setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

// Другие методы класса...

    @Override
    public String toString() {
        String foundationInfo = (this.getYearsOfFoundation() == 0) ? "" : " основан в " + this.getYearsOfFoundation() + " году";
        String profileInfo = (this.getMainProfile() == null) ? "" : ", направление " + this.getMainProfile();
        return this.getFullName() + " (" + this.getShortName() + ")" + foundationInfo + profileInfo + ".";
    }

}
