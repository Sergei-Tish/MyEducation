//Копия из урока

// Базовый нотификатор. На схеме ConcreteComponent.
// Отправляет сообщение по e-mail.
class BaseNotifier implements Notifier {
    BaseNotifier(){}// Базовый конструктор
    @Override
    public String sendData() {
        return "Отправляю сообщения по e-mail. ";
    }
}