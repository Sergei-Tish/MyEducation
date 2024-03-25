// клиентская часть
public class MainMediator {
    public static void main(String[] args) {
        Admin admin = new Admin();// создаем конкретного коллегу admin
        Editor editor = new Editor();// создаем конкретного коллегу editor
        // создаем конкретного посредника и передаем в конструктор конкретных коллег
        ConcreteMediator mediator = new ConcreteMediator(admin, editor);

        System.out.println("\nAdmin send message \"Hello\":");
        admin.send("Hello I'm admin");// admin отправляет сообщение посреднику
        System.out.println("\nEditor send message \"Hello\":");
        editor.send("Hello I'm editor"); // editor отправляет сообщение посреднику
    }
}

// Создаем конкретного посредника, который содержит ссылки на конкретные объекты классов-коллег
class ConcreteMediator implements Mediator{
    private Admin admin;// ссылка на объект класса Admin
    private Editor editor;// Ссылка на объект класса Editor
    // Конструктор конкретного медиатора принимает конкретные объекты-коллеги
    // в ходе создания конкретного посредника объектам-коллегам устанавливаем посредника
    public ConcreteMediator(Admin admin, Editor editor) {
        this.admin = admin;
        this.editor = editor;
        editor.setMediator(this);
        admin.setMediator(this);
    }
    // Переопределяем метод отправки сообщения
    @Override
    public void sendMessage(String message, Collegue collegue) {
        if (collegue.equals(admin)){// если сообщение отправляет admin, оно отправляется объекту editor
            editor.getMessage(message);
        } else if (collegue.equals(editor)){// если сообщение отправляет editor, оно отправляется объекту admin
            admin.getMessage(message);
        }
    }
}

// конкретный класс-коллега, наследует метод отправки сообщений от абстрактного класса
class Admin extends Collegue{
    @Override // переопределяем метод получения сообщения для наглядности работы
    void getMessage(String message) {
        System.out.println("Admin get message - \"" + message + "\"");
    }
}
// конкретный класс-коллега, наследует метод отправки сообщений от абстрактного класса
class Editor extends Collegue{
    @Override // переопределяем метод получения сообщения для наглядности работы
    void getMessage(String message) {
        System.out.println("Editor get message - \"" + message + "\"");
    }
}