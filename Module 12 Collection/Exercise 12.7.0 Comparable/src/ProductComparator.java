import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        String serialNumber1 = String.valueOf(p1.getSerialNumber());
        String serialNumber2 = String.valueOf(p2.getSerialNumber());
        // Получаем числа из серийных номеров
        int number1 = Integer.parseInt(serialNumber1.replaceAll("[^\\d]", ""));
        int number2 = Integer.parseInt(serialNumber2.replaceAll("[^\\d]", ""));
        // Сравниваем числа в обратном порядке
        return Integer.compare(number1, number2);
    }
}