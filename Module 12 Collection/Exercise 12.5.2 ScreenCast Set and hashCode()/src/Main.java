import java.util.*;

public class Main {

    private static final String TOYOTA = "Toyota";
    private static final String BMW = "BMW";
    private static final String KIA = "KIA";

    public static void main(String[] args) {
        Car car1 = new Car(TOYOTA, "1", false);
        Car car2 = new Car(TOYOTA, "2", false);
        Car car3 = new Car(BMW, "3", false);
        Car car4 = new Car(KIA, "4", false);
        Car car5 = new Car(BMW, "5", false);
        Car car6 = new Car(TOYOTA, "6", true);
        Car car7 = new Car(BMW, "7", false);
        Car car8 = new Car(BMW, "8", false);
        Car car9 = new Car(KIA, "9", false);
        Car car10 = new Car(TOYOTA, "10", false);
        Car car11 = new Car(TOYOTA, "1", false);
        Car car12 = new Car(TOYOTA, "2", false);
        Car car13 = new Car(BMW, "3", false);
        Car car14 = new Car(KIA, "4", false);
        Car car15 = new Car(BMW, "5", false);
        Car car16 = new Car(TOYOTA, "6", true);
        Car car17 = new Car(BMW, "7", false);
        Car car18 = new Car(BMW, "8", false);
        Car car19 = new Car(KIA, "9", false);
        Car car20 = new Car(TOYOTA, "10", false);
        Car car21 = new Car(TOYOTA, "1", false);
        Car car22 = new Car(TOYOTA, "2", false);
        Car car23 = new Car(BMW, "3", false);
        Car car24 = new Car(KIA, "4", false);
        Car car25 = new Car(BMW, "5", false);
        Car car26 = new Car(TOYOTA, "6", true);
        Car car27 = new Car(BMW, "7", false);
        Car car28 = new Car(BMW, "8", false);
        Car car29 = new Car(KIA, "9", false);
        Car car30 = new Car(TOYOTA, "10", false);

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
        carList.add(car11);
        carList.add(car12);
        carList.add(car13);
        carList.add(car14);
        carList.add(car15);
        carList.add(car16);
        carList.add(car17);
        carList.add(car18);
        carList.add(car19);
        carList.add(car20);
        carList.add(car21);
        carList.add(car22);
        carList.add(car23);
        carList.add(car24);
        carList.add(car25);
        carList.add(car26);
        carList.add(car27);
        carList.add(car28);
        carList.add(car29);
        carList.add(car30);

        Set<Car> carSet = new HashSet<>(carList);

        int countCarInCarSet = 1;
        for (Car car: carSet) {
            System.out.println(countCarInCarSet++ + " " + car + car.hashCode());
        }

//        for (Car car :
//                carList) {
//            if (car.getBrand().equals(KIA)) {
//                carList.remove(car);
//            }
//        }

////        carList.removeIf(car -> car.getBrand().equals(KIA));    // Автозаполнение IJ

//        Iterator<Car> carIterator = carList.iterator();
//        while (carIterator.hasNext()) {
//            Car car = carIterator.next();
//            if (car.getBrand().equals(KIA)) {
//                carIterator.remove();
//            }
//        }
//
//        for (Car car :
//                carList) {
//            if (car.getBrand().equals(TOYOTA)) {
//                car.setOnSale(true);
//            }
//        }
//        int countCarInList = 1;
//        for (Car car :
//                carList) {
//            System.out.println(countCarInList++ + " " + car);
//        }

    }
}
