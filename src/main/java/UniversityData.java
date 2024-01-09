public class UniversityData {
    private String id;
    private String fullName;
    private String shortName;
    private int yearsOfFoundation;
    private StudyProfile mainProfile;

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
}
