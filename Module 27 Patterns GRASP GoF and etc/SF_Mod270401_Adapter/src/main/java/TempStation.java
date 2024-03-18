import tempadapter.FahrenheitToCelsiusAdapter;

/**Задание 27.4.1
 * Создайте класс с одним методом, который будет выводить на экран температуру по Фаренгейту,
 * и подключите его к домашней метеостанции, которая выводит температуру в градусах по Цельсию.
 * Для решения используйте паттерн Адаптер.*/

public class TempStation {
    public static void main(String[] args) {
        TempFahrenheitInterface sensor = new FahrenheitSensor();
        sensor.getFahrenheit();

        System.out.println();

        TempFahrenheitInterface sensor2 = new FahrenheitToCelsiusAdapter();
        sensor2.getFahrenheit();
    }
}
