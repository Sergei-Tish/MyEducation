import java.util.Scanner;

public class Main {
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79787775747";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStorage executor = new StudentStorage();
        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            if (tokens[0].equals("add")) {
                try {
                    executor.addStudent(tokens[1]);
                } catch (Exception e) {
                    errorExceptionPrint(1);
                }
            } else if (tokens[0].equals("list")) {
                executor.listStudent();
            } else if (tokens[0].equals("get")) {
                try {
                    executor.getStudentByName(tokens[1]).toString();
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    errorExceptionPrint(2);
                }
                catch (Exception e) {
                    errorExceptionPrint(3);
                }
            } else if (tokens[0].equals("remove")) {
                try {
                    executor.removeStudent(tokens[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    errorExceptionPrint(2);
                }
            } else if (tokens[0].equals("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                System.out.println(helpText);
            } else {
                System.out.println(commandError);
            }
        }
    }

    private static void errorExceptionPrint(int number) {
        switch (number) {
            case 1 -> System.out.println("Необходимо вводить данные учащегося для помещения его в список");
            case 2 -> System.out.println("Необходимо вводить имя и фамилию учащегося из списка");
            case 3 -> System.out.println("Ошибка ввода");
        }
    }
}