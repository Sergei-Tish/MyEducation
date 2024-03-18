// Copy paste
// Создаем абстрактный класс Handler, который будет описывать всех обработчиков. На схеме - "Interface" Handler
public abstract class Handler {
    private int priority;// нужно для сравнения условий в каждом обработчике
    private Handler nextHandler; // Ссылка на следующий обработчик в цепи, может быть null.

    // Создаем конструктор, принимающий приоритет
    public Handler(int priority) {
        this.priority = priority;
    }

    // Сеттер для установки следующего в цепочке обработчика запроса
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Метод служит сравнения полученного запроса с условием и обрабатывает запрос сам, либо передает его по цепочке. Переменная condition передает данные, которые нужно сравнить с нашим приоритетом.
    public void handlerManager(String message, int condition) {
        if (condition >= priority) {// если условия проверки выполняются
            write(message);// выводим сообщение
        }
        // Если нужно, чтобы срабатывал только один обработчик - раскомментируйте следующую строку с оператором else

//        else         // Далее проверяем наличие следующего в цепи обработчика
        if (nextHandler != null) {// если следующий обработчик существует, вызываем его и передаем ему переменные message и condition
            nextHandler.handlerManager(message, condition);
        } else {
            System.out.println("\n=======================\n");// эта строка кода для наглядности
        }
    }

    public abstract void write(String message);// выводит сообщение message, переопределяем для каждого обработчика
}

// Описывает условия, с которыми будем сравнивать запрос
class Priority {
    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
}

// конкретный обработчик
class FirstHandler extends Handler {
    public FirstHandler(int priority) {// вызываем конструктор суперкласса
        super(priority);
    }

    @Override// переопределяем метод write()
    public void write(String message) {
        System.out.println("Event handling with FirstHandler \n\"" + message + "\"");
    }
}

// конкретный обработчик
class SecondHandler extends Handler {// вызываем конструктор суперкласса

    public SecondHandler(int priority) {
        super(priority);
    }

    @Override //переопределяем метод write()
    public void write(String message) {
        System.out.println("Event handling with SecondHandler \n\"" + message + "\"");
    }
}

// конкретный обработчик
class ThirdHandler extends Handler {// вызываем конструктор суперкласса

    public ThirdHandler(int priority) {
        super(priority);
    }

    @Override //переопределяем метод write()
    public void write(String message) {
        System.out.println("Event handling with ThirdHandler \n\"" + message + "\"");
    }
}

class Client {
    public static void main(String[] args) {
        // Создаем объекты обработчиков и каждому передаем приоритет, с которым будет сравниваться запрос
        Handler firstHandler = new FirstHandler(Priority.INFO);
        Handler secondHandler = new SecondHandler(Priority.WARNING);
        Handler thirdHandler = new ThirdHandler(Priority.ERROR);

        firstHandler.setNextHandler(secondHandler);// первому обработчику назначаем следующего
        secondHandler.setNextHandler(thirdHandler);// второму обработчику назначаем следующего
        // Вызываем handlerManager() у первого обработчика и передаем ему сообщение и параметр, который нужно обработать
        firstHandler.handlerManager("We are fine...", Priority.INFO);
        firstHandler.handlerManager("There is a reason to think...", Priority.WARNING);
        firstHandler.handlerManager("Help me please!!!", Priority.ERROR);
    }
}