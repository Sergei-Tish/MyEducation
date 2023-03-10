import java.util.HashMap;

public class StudentStorage {
    private HashMap<String, Student> storage;

    public StudentStorage() {
        storage = new HashMap<>();
    }

    public void addStudent(String data) {
        int studentCount = storage.size();
        String[] components = data.split("\\s+");
        String name = null;
        try {
            name = components[0] + " " + components[1];
        } catch (Exception e) {
            errorExceptionPrint(1);
        }
        try {
            storage.put(name, new Student(name, components[3], components[2]));
        } catch (ArrayIndexOutOfBoundsException e) {
            errorExceptionPrint(3);
            return;
        }
        if (studentCount+1 == storage.size()) System.out.println("Учащийся добавлен в список");
    }

    public void listStudent() {
        if (storage.isEmpty()) System.out.println("Список студентов пуст.");
        else storage.values().forEach(System.out::println);
    }

    public void removeStudent(String name) {
        if (!storage.containsKey(name)) System.out.println("Такого учащегося нет в списке");
        storage.remove(name);
    }

    public Student getStudentByName(String name) {
        try {
            return storage.get(name);
        } catch (Exception e) {
            errorExceptionPrint(4);
            return null;
        }
    }

    public int getCount() {
        return storage.size();
    }

    private void errorExceptionPrint(int components) {
        switch (components) {
            case 1 -> System.out.println("Необходимо ввести фамилию учащегося.");
            case 2, 3 -> System.out.println("Необходимо ввести эл.почту и номер телефона.");
            case 4 -> System.out.println("Неверный ввод");
        }
    }
}