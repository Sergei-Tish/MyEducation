public class FahrenheitToCelsiusAdapter extends CelsiusSensor implements TempFahrenheitInterface {
    // F = (C x 1,8) + 32
    // C = (F - 32) / 1,8
    @Override
    public void showCelsius() {
        super.showCelsius();
    }

    @Override
    public void getFahrenheit() {
        showCelsius();
    }
}
