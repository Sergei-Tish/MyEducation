import java.util.*;

public class ProductSortDemo {

    public static void main(String[] args) {
        // Создаем список продуктов
        Set<Product> products = new TreeSet<>(Comparator.reverseOrder());
        products.add(new Product("A123B", "Product 1"));
        products.add(new Product("C456D", "Product 2"));
        products.add(new Product("E789F", "Product 3"));
        products.add(new Product("G123H", "Product 4"));
        products.add(new Product("I456J", "Product 5"));

        // Сортируем список по компаратору


        // Выводим отсортированный список
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
