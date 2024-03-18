//Копия из урока

//Улучшеный декоратор, добаляет отправку сообщения в телеграмм.
class AdvencedDecoratorTG extends NotifierDecorator {
    AdvencedDecoratorTG(Notifier notifier) {
        super(notifier);
    }

    // отправка сообщения в телеграмм
    public String sendToTelegram() {
        return "Отправляю сообщение в телеграмм";
    }

    @Override
    public String sendData() {// к основной отправке сообщения добавляем отпраку в телеграмм
        return super.sendData() + sendToTelegram();
    }
}