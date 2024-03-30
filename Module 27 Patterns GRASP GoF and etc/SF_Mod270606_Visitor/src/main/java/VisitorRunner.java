//копипаста для изучения SF_Mod270606_Visitor

public class VisitorRunner {
    public static void main(String[] args) {
        ProductCollection pc = new ProductCollection();// создаем коллекцию товаров
        RubPriceVisitor rubPriceVisitor = new RubPriceVisitor();// создаем посетителя, которые переведет цену в российские рубли
        BynPriceVisitor bynPriceVisitor = new BynPriceVisitor();// создаем посетителя, которые переведет цену в белорусские рубли

        System.out.println("RUB");
        System.out.println(pc.getCost(rubPriceVisitor));// пересчитываем стоимость товаров корзины в российские рубли
        System.out.println("\n++++++++++++++++++++++++\n");
        System.out.println("BYN");
        System.out.println(pc.getCost(bynPriceVisitor));// пересчитываем стоимость товаров корзины в белорусские рубли

    }
}
// Интерфейс Product описывает метод getCost() для всех товаров. Соответствует Element на диаграмме классов.
interface Product{
    // добавляем новое поведение поведение всем товарам
    // соответствует методу accept() на диаграмме, принимает интерфейс посетителя в качестве аргумента
    double getCost(Visitor visitor);
}
// наши велосипеды, имеют одно поле - цена в долларах (конкретный элемент на схеме)
class Bike implements Product{
    private double usdPrice;// цена в долларах

    public Bike(double usdPrice) {
        this.usdPrice = usdPrice;
    }// конструктор, принимает цену

    public double getUsdPrice() {
        return usdPrice;
    }// геттер для цены

    @Override //переопределяем метод getCost() интерфейса для вызова конкретного посетителя
    public double getCost(Visitor visitor) {
        return visitor.bikePriceVisitor(this);// вызывает посещение конкретного посетителя, добавляет новое поведение
    }

}
// телевизоры с ценой в долларах (конкретный элемент на схеме)
class TV implements Product{
    private double usdPrice;// цена

    public TV(double usdPrice) {
        this.usdPrice = usdPrice;
    }// конструктор

    public double getUsdPrice() {
        return usdPrice;
    }// геттер для цены

    @Override //переопределяем метод getCost() интерфейса для вызова конкретного посетителя
    public double getCost(Visitor visitor) {
        return visitor.tvPriceVisitor(this);// вызывает посещение конкретного посетителя, добавляет новое поведение
    }
}
// корзина продуктов (коллекция на схеме)
class ProductCollection{
    Product[] products;// содержит массив конкретных продуктов
    // для упрощения примера наполним коллекцию товарами при создании
    public ProductCollection() {
        this.products = new Product[]{
                new Bike(128),
                new Bike(223),
                new TV(414),
                new TV(214),
                new TV(164),
                new Bike(1134)
        };
    }
    // переводим цену в российские или белорусские рубли и подсчитаем стоимость товаров в корзине
    public double getCost(Visitor visitor) {
        double price = 0;// стоимость товаров в пустой корзине
        for (Product product : products){// перебираем все элементы корзины
            price += product.getCost(visitor); // переводим в российские или белорусские рубли и подсчитываем общую сумму товаров в корзине
        }
        return price;// возвращаем стоимость товаров в корзине в российских или белорусских рублях
    }
}

//интерфейс посетителя, добавляет новое поведение
interface Visitor{
    double bikePriceVisitor(Bike bike);// посетитель класса велосипедов, пересчитывает цену (обеспечивает новое поведение), метод visit на схеме
    double tvPriceVisitor(TV tv);// посетитель класса телевизоров, пересчитывает цену (обеспечивает новое поведение), метод visit на схеме

    default void printPrice(Product product, double price, String currency) {
        System.out.println(product.getClass().getName() + " costs: " + price + " " + currency);//выводим цену на экран
    }
}

// Конкретные посетители обычно реализует одну операцию для всей иерархии элементов.Каждая новая операция это новый посетитель.
// Посетителя выгодно применять, когда новые элементы добавляются очень редко, а новые операции - часто.
// переводит цену в белорусские рубли
class BynPriceVisitor implements Visitor{
    // для велосипедов
    @Override
    public double bikePriceVisitor(Bike bike) {
        double price = bike.getUsdPrice() * 3.25;// переводим цену в белорусские рубли
        printPrice(bike, price, "BYN");
        return price;// возвращаем новую цену
    }

    // для телевизоров
    @Override
    public double tvPriceVisitor(TV tv) {
        double price = tv.getUsdPrice() * 3.25;// переводим цену в белорусские рубли
        printPrice(tv, price, "BYN");
        return price;// возвращаем новую цену
    }
}
// переводит цену в российские рубли
class RubPriceVisitor implements Visitor{
    // для велосипедов
    @Override
    public double bikePriceVisitor(Bike bike) {
        double price = bike.getUsdPrice() * 92.37;// переводим цену в российские рубли
        printPrice(bike, price, "RUB");
        return price;// возвращаем новую цену
    }

    // для телевизоров
    @Override
    public double tvPriceVisitor(TV tv) {
        double price = tv.getUsdPrice() * 92.37;// переводим цену в российские рубли
        printPrice(tv, price, "RUB");//выводим цену на экран
        return price;// возвращаем новую цену
    }
}