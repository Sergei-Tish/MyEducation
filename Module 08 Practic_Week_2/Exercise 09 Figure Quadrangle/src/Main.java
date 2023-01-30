public class Main {
    public static void main(String[] args) {
        Parallelogram parallelogram = new Parallelogram(1, 2, 60, 120, "Pink");
        Parallelogram parallelogram1 = new Parallelogram(2, 1, 60, 120, "Pink");
        Parallelogram parallelogram2 = new Parallelogram(1, 2, 90, 90, "White");
        Parallelogram parallelogram3 = new Parallelogram(2, 3, 60, 120, "Pink");

        System.out.println(parallelogram.getLargeDiagonal());
        System.out.println(parallelogram.getLargeDiagonal() >= 2.64 && parallelogram.getLargeDiagonal() <= 2.65);
        System.out.println(
                parallelogram.area() >= 1.73 && parallelogram.area() <= 1.74 &&
                parallelogram.perimeter() == 6);


        /* проверка Ромба не совпадает
        Rhombuses rhombuses = new Rhombuses(1, 60, 120, "Pink");
        Rhombuses rhombuses1 = new Rhombuses(1, 90, 90, "Pink");
        Rhombuses rhombuses2 = new Rhombuses(2, 60, 120, "Pink");
        System.out.println(rhombuses.getHeight  () + " " + Math.sqrt(3) / 2);
        System.out.println(rhombuses.getHeight  () == Math.sqrt(3) / 2);      // Не ясно мнепочему тут отклонение такое
        System.out.println(rhombuses1.getHeight() == 1);
        System.out.println(rhombuses2.getHeight() +" "+ 2 * Math.sqrt(3) / 2);
        System.out.println(rhombuses2.getHeight() == 2 * Math.sqrt(3) / 2);
        */
    }
}