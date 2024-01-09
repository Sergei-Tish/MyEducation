import java.util.HashMap;

public class University {
    private String id;

    public static HashMap<String, UniversityData> universityHashMap = new HashMap<>();


    public University(String id, String fullName, String shortName) {
        this(id, fullName, shortName, 0, null);
    }

    public University(String id, String fullName, String shortName, int yearsOfFoundation) {
        this(id, fullName, shortName, yearsOfFoundation, null);
    }

    public University(String id, String fullName, String shortName, StudyProfile mainProfile) {
        this(id, fullName, shortName, 0, mainProfile);
    }

    public University(String id, String fullName, String shortName, int yearsOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        UniversityData universityData = new UniversityData(id, fullName, shortName, yearsOfFoundation, mainProfile);
    }

    public String getId() {
        return universityHashMap.get(this.id).getId();
    }

    public University setId(String newId) {
        UniversityData universityData = universityHashMap.remove(this.id);
        if (universityData != null) {
            universityData.setId(newId);
            universityHashMap.put(newId, universityData);
        }
        this.id = newId;
        return this;
    }

    public String getFullName() {
        if (universityHashMap.get(this.id).getFullName() != null) {
            return universityHashMap.get(this.id).getFullName();
        } else {
            return "!!!ОШИБКА!!! при исполнении: в University  String getFullName()";
        }
    }

    public University setFullName(String fullName) {
        if (universityHashMap.get(this.id) != null) {
            universityHashMap.get(this.id).setFullName(fullName);
        } else {
            System.out.println("!!!ОШИБКА!!! при исполнении: в University setFullName(String fullName)");
        }
        return this;
    }

    public String getShortName() {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            return universityData.getShortName();
        } else {
            return "!!!ОШИБКА!!! при исполнении: в University - String getShortName()";
        }
    }


    public University setShortName(String newShortName) {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            universityData.setShortName(newShortName);
        } else {
            System.out.println("!!!ОШИБКА!!! при исполнении: в University setShortName(String newShortName)");
        }
        return this;
    }

    public int getYearsOfFoundation() {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            return universityData.getYearsOfFoundation();
        } else {
            return 0; // Или другое значение по умолчанию
        }
    }

    public University setYearsOfFoundation(int newYearsOfFoundation) {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            universityData.setYearsOfFoundation(newYearsOfFoundation);
        } else {
            System.out.println("ОШИБКА при исполнении: в University setYearsOfFoundation(int newYearsOfFoundation)");
        }
        return this;
    }

    public StudyProfile getMainProfile() {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            return universityData.getMainProfile();
        } else {
            return null; // Или другое значение по умолчанию
        }
    }

    public University setMainProfile(StudyProfile newMainProfile) {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            universityData.setMainProfile(newMainProfile);
        } else {
            System.out.println("ОШИБКА при исполнении: в University setMainProfile(StudyProfile newMainProfile)");
        }
        return this;
    }

    @Override
    public String toString() {
        String foundationInfo = (this.getYearsOfFoundation() == 0) ? "" : " основан в " + this.getYearsOfFoundation() + " году";
        String profileInfo = (this.getMainProfile() == null) ? "" : ", направление " + this.getMainProfile();
        return this.getFullName() + " (" + this.getShortName() + ")" + foundationInfo + profileInfo + ".";
    }
}
