// Создаем общий интерфейс для всех посредников
interface Mediator{
    // Для примера будет содержать один отправки сообщений
    // в качестве аргументов принимает само сообщение и объект-коллегу, который отправил это сообщение
    void sendMessage(String message, Collegue collegue);
}