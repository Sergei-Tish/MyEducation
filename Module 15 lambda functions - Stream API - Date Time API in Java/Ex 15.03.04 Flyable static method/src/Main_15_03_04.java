public class Main_15_03_04 {

}
class Bird implements Flyable {
    private void fly() {
        System.out.println("Bird flying");
    }
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly(); // строка 2
        Vimpire bird1 = new Vimpire();
        bird1.kiss();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

interface Flyable {
    static void fly() { // строка 1
        System.out.println("Flying");
    }
}

class Vimpire implements Flyable {
    public void kiss() {
        System.out.println("kiss");
    }
}