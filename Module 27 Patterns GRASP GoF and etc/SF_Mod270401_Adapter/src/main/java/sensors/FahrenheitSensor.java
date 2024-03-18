package sensors;

import io.InputTemp;
import tempinterface.TempFahrenheitInterface;

public class FahrenheitSensor implements TempFahrenheitInterface {
    // F = (C x 1,8) + 32
    // C = (F - 32) / 1,8
    @Override
    public void getFahrenheit() {
        System.out.println("Нормальная температура тела = " + InputTemp.bodyTempFahrenheit + "°F");
        System.out.println("Сейчас за окном " + InputTemp.outdoorTempFahrenheit + "°F");
    }
}
