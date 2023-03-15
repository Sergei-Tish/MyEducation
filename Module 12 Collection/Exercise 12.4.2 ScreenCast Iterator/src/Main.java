import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static final String TOYOTA = "Toyota";
    private static final String BMW = "BMW";
    private static final String KIA = "KIA";

    public static void main(String[] args) {
        Car car1 = new Car(TOYOTA, "1", false);
        Car car2 = new Car(TOYOTA, "1", false);
        Car car3 = new Car(BMW, "2", false);
        Car car4 = new Car(KIA, "3", false);
        Car car5 = new Car(BMW, "2", false);
        Car car6 = new Car(TOYOTA, "1", true);
        Car car7 = new Car(BMW, "2", false);
        Car car8 = new Car(BMW, "2", false);
        Car car9 = new Car(KIA, "3", false);
        Car car10 = new Car(TOYOTA, "1", false);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        carList.add(car7);
        carList.add(car8);
        carList.add(car9);
        carList.add(car10);

//        for (Car car :
//                carList) {
//            if (car.getBrand().equals(KIA)) {
//                carList.remove(car);
//            }
//        }
////        carList.removeIf(car -> car.getBrand().equals(KIA));    // Автозаполнение IJ

        Iterator<Car> carIterator = carList.iterator();
        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            if (car.getBrand().equals(KIA)) {
                carIterator.remove();
            }
        }

        for (Car car :
                carList) {
            if (car.getBrand().equals(TOYOTA)) {
                car.setOnSale(true);
            }
        }
        for (Car car :
                carList) {
            System.out.println(car);
        }
    }
}
