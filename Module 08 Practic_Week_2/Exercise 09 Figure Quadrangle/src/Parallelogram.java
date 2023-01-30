public class Parallelogram extends Quadrangle implements Figure {
    double alpha, beta;
    double alphaRad = Math.toRadians(alpha);
    double betaRad = Math.toRadians(beta);
    public Parallelogram (int a, int b, double alpha, double beta, String color) {
        super(a, b, color);
        this.alpha = alpha;
        this.beta = beta;
        alphaRad = Math.toRadians(alpha);
        betaRad = Math.toRadians(beta);
    }

    @Override
    public double area() {
        return a * b * Math.sin(alphaRad);
    }

    @Override
    public double perimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    public double getLargeDiagonal() {
        double dLow = Math.sqrt(a*a + b*b + 2 * a * b * Math.cos(betaRad));
        double dLarge = Math.sqrt((a*a + b*b + 2 * a * b * Math.cos(alphaRad)));
        return dLarge; //a*(Math.sqrt(2 + 2*Math.cos(alphaRad)));
    }

    @Override
    public double getHeight() {
        return area()/Math.max(a, b);
    }

    @Override
    public String getColor() {
        return color;
    }
}
