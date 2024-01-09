

public class Main {
    public static void main(String[] args) {
        University university0 = new University("0", "АлтайГосТехнУнивер", "АлтГТУ");
        University university1 = new University("1", "АлтайГосУнивер", "АГУ", 1702);
        University university2 = new University("2", "НовосГосТехнУнивер", "НГТУ", 1803, StudyProfile.COMPUTER_SCIENCE);
        University university3 = new University("3", "МосковГосМедУнивер", "МГМУ", StudyProfile.MEDICINE);

        System.out.println(university0);
        System.out.println(university1);
        System.out.println(university2);
        System.out.println(university3);

        System.out.println();

        Student student  = new Student("Tishchenko Sergey Ivanovich");
        Student student1 = new Student("Тищенко Сергей Иванович", "0");
        Student student2 = new Student("Язвенко Ядослав Влерьевич", "3", 3);
        Student student3 = new Student("Древнерусов Дрочеслав сын'Сергея", "2", 2, 3.3f);
        Student student4 = new Student("Грибнов Тимофей Хомякович", "5", 2, 3.3f);

        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

    }
}
