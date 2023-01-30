public class Square extends Quadrangle implements Figure {
    public Square(int a, String color) {
        super(a, a, color);
    }

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimeter() {
        return 2 * a + 2 * a;
    }

    @Override
    public double getLargeDiagonal() {
        return Math.sqrt(a * a + a * a);
    }

    @Override
    public double getHeight() {
        return a;
    }

    @Override
    public String getColor() {
        return color;
    }
}
