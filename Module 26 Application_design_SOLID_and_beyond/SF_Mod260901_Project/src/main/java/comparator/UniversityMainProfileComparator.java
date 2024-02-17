package comparator;

import enums.StudyProfile;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityMainProfileComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        int compare = StringUtils.compare(o1.getMainProfile().getProfileName(), o2.getMainProfile().getProfileName());
        return compare;
    }
}
