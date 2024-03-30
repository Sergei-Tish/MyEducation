//копипаста для изучения SF_Mod270605_Template_Method

public class TemplateMethodeRunner {
    public static void main(String[] args) {
        // Переменную docWork назначаем объектом CSV
        DocWork docWork = new CSV();
        docWork.handleDoc();// Вызываем  шаблонный метод
        System.out.println("\n=============================\n");
        // Переменную docWork назначаем объектом PDF
        docWork = new PDF();
        docWork.handleDoc();// Вызываем  шаблонный метод
    }
}

//Абстрактный  класс, который описывает шаблонный метод и атомарные операции, из которых он состоит
abstract class DocWork{
    // шаблонный метод состоит из последовательно исполняемых атомарных методов
    public void handleDoc(){
        loadDoc();
        rework();
        exit();
    }
    //Общий для всех классов метод реализуем сразу
    void loadDoc(){
        System.out.println("Document Loading");
    }
    //Изменяемые методы будем описывать в их классах
    abstract void rework();
    abstract void exit();
}

//Подклассы реализуют атомарные методы, не трогая шаблонный метод.  Для PDF и CSV будет работать по-разному.
class PDF extends DocWork{
    @Override
    protected void rework() {
        System.out.println("Обработка PDF");
    }

    @Override
    protected void exit() {
        System.out.println("Конец PDF");
    }
}

class CSV extends DocWork{
    @Override
    protected void rework() {
        System.out.println("Обработка CSV");
    }

    @Override
    protected void exit() {
        System.out.println("Конец CSV");
    }
}