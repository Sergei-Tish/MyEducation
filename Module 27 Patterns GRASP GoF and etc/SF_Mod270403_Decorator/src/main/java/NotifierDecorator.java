//Копия из урока

//Родитель всех декораторов. На схеме Decorator.
abstract class NotifierDecorator implements Notifier {
    Notifier notifier;// ссылка на изменяемый объект
    NotifierDecorator(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public String sendData() {
        // Метод sendData() вызывает sendData() у объекта notifier.
        return notifier.sendData();
    }
}
