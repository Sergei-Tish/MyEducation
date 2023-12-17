

public class Main {
    public static void main(String[] args) {
        University university0  = new University("0", "АлтайГосУнивер", "АГУ");
        University university1 = new University("1", "АлтайГосТехнУнивер", "АГТУ", 1702);
        University university2 = new University("2", "НовосГосТехнУнивер", "НГТУ", 1803, StudyProfile.COMPUTER_SCIENCE);
        University university3 = new University("3", "МосковГосМедУнивер", "МГМУ", 1904, StudyProfile.MEDICINE);

        System.out.println(university0);
        System.out.println(university1);
        System.out.println(university2);
        System.out.println(university3);

        Student student  = new Student("Tishchenko Sergey Ivanovich");
        Student student1 = new Student("Tishchenko Valeria Olegovna", "0");
        Student student2 = new Student("YAzvenko Lera doch'Olega", "3", 3);
        Student student3 = new Student("Elderrus Drocheslav synSergeya", "2", 2, 3.3f);

        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

    }
}
