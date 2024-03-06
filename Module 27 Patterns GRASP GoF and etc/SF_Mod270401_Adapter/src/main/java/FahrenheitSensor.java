public class FahrenheitSensor implements TempFahrenheitInterface {
    // F = (C x 1,8) + 32
    // C = (F - 32) / 1,8
    @Override
    public void getFahrenheit() {
        System.out.println("Yормальная температура тела = " + InputTemp.bodyTempFahrenheit + "°F");
        System.out.println("Сейчас за окном " + InputTemp.outdoorTempFahrenheit + "°F");
    }
}
