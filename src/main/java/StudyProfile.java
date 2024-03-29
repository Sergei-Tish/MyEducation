

public enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Инженерное дело"),
    COMPUTER_SCIENCE("Информатика"),
    PEDAGOGY("Педагогика");

    private String profileName;

    @Override
    public String toString() {
        return profileName;
    }

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}