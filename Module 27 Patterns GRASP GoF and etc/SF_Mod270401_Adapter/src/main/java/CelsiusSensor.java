public class CelsiusSensor implements TempCelsiusInterface {
    @Override
    public void showCelsius() {
        double bodyTempCelsius = convertFahrenheitToCelsius(InputTemp.bodyTempFahrenheit);
        System.out.println("Yормальная температура тела = " + bodyTempCelsius + "°C");

        double outdoorTempCelsius = convertFahrenheitToCelsius(InputTemp.outdoorTempFahrenheit);
        System.out.println("Сейчас за окном " + outdoorTempCelsius + "°C");
    }

    private static double convertFahrenheitToCelsius(double FahrenheitTemp) {
        double outdoorTempCelsius = (FahrenheitTemp - 32) / 1.8;
        outdoorTempCelsius = Math.round((outdoorTempCelsius) * 10.0) / 10.0;
        return outdoorTempCelsius;
    }
}
