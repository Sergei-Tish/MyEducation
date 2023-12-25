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
            return "ОШИБКА при исполнении: public String getFullName()";
        }

    }

    public University setFullName(String fullName) {
        if (universityHashMap.get(this.id) != null) {
            universityHashMap.get(this.id).setFullName(fullName);
        } else {
            System.out.println("ОШИБКА при исполнении: public University setFullName(String fullName)");
        }
        return this;
    }

    public String getShortName() {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            return universityData.getShortName();
        } else {
            return "ОШИБКА при исполнении: public String getShortName()";
        }
    }

    public University setShortName(String newShortName) {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            universityData.setShortName(newShortName);
        } else {
            System.out.println("ОШИБКА при исполнении: public University setShortName(String newShortName)");
        }
        return this;
    }

    public int getYearsOfFoundation() {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            return universityData.getYearsOfFoundation();
        } else {
            return -1; // Или другое значение по умолчанию
        }
    }

    public University setYearsOfFoundation(int newYearsOfFoundation) {
        UniversityData universityData = universityHashMap.get(this.id);
        if (universityData != null) {
            universityData.setYearsOfFoundation(newYearsOfFoundation);
        } else {
            System.out.println("ОШИБКА при исполнении: public University setYearsOfFoundation(int newYearsOfFoundation)");
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
            System.out.println("ОШИБКА при исполнении: public University setMainProfile(StudyProfile newMainProfile)");
        }
        return this;
    }


//    public String getShortName() {
//        return universityHashMap.get(this.id).getShortName();
//    }
//
//    public University setShortName(String newShortName) {
//        universityHashMap.get(this.id).setShortName(newShortName);
//        return this;
//    }
//
//    public int getYearsOfFoundation() {
//            return universityHashMap.get(this.id).getYearsOfFoundation();
//    }
//
//    public University setYearsOfFoundation(int newYearsOfFoundation) {
//        universityHashMap.get(this.id).setYearsOfFoundation(newYearsOfFoundation);
//        return this;
//    }
//
//    public StudyProfile getMainProfile() {
//        return universityHashMap.get(this.id).getMainProfile();
//    }
//
//    public University setMainProfile(StudyProfile newMainProfile) {
//        universityHashMap.get(this.id).setMainProfile(newMainProfile);
//        return this;
//    }

    @Override
    public String toString() {
        return universityHashMap.get(this.id).toString();
    }
}
