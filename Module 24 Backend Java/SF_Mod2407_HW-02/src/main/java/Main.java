

public class Main {
    public static void main(String[] args) {
        University university = new University("0", "АлтайГосУнивер", "АГУ");
        University university1 = new University("1", "АлтайГосТехнУнивер", "АГТУ", 1702);
        University university2 = new University("2", "НовосГосТехнУнивер", "НГТУ", 1803, StudyProfile.COMPUTER_SCIENCE);
        University university3 = new University("3", "МосковГосМедУнивер", "МГМУ", 1904, StudyProfile.MEDICINE);

        System.out.println(university);
        System.out.println(university1);
        System.out.println(university2);
        System.out.println(university3);


    }
}
