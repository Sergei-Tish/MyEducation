// абстрактный класс для всех коллег, содержит ссылку на посредника
abstract class Collegue{
    private Mediator mediator;// ссылка на посредника
    public void setMediator(Mediator mediator){//устанавливаем посредника коллеге
        this.mediator = mediator;
    }
    //Метод отправки сообщения. Сообщение отправляется посреднику, а он определяет дальнейшего получателя. Отправитель не имеет представления кто получит сообщение.
    void send(String message){
        mediator.sendMessage(message, this);
    }
    abstract void getMessage(String message);// метод получения сообщения для наглядности работы примера
}