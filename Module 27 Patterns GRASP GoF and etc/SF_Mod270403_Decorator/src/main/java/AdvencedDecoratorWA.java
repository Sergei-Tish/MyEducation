

//Улучшеный декоратор, добаляет отправку сообщения в ватсапп.
public class AdvencedDecoratorWA extends NotifierDecorator {
    AdvencedDecoratorWA(Notifier notifier) {
        super(notifier);
    }

    // отправка сообщения в ватсап
    public String sendWatsApp() {
        return "Отправка сообщения в ватсапп";
    }

    @Override
    public String sendData() {// к основной отправке сообщения добавляем отпраку в ватсапп
        return super.sendData() + sendWatsApp();
    }
}
