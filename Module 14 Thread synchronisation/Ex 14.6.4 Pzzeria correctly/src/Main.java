public class Main {


    public static void main(String[] args) throws InterruptedException{

        Pizzeria pizzeria = new Pizzeria();
        pizzeria.order("Margarita");
        Thread.sleep(100);
        pizzeria.order("Pepperoni");
        Thread.sleep(100);
        pizzeria.order("Sicilian");
        Thread.sleep(100);
        pizzeria.order("Greek");

    }

}
/** print:
 Margarita is delivered
 Sicilian is NOT delivered
 Greek is delivered
 Pepperoni is delivered
 */