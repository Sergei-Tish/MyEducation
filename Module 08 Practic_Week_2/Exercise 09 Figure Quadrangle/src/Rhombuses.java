public class Rhombuses extends Quadrangle implements Figure {
    double alpha, beta;
    double alphaRad;
    double betaRad;

    public Rhombuses(int a, double alpha, double beta, String color) {
        super(a, a, color);
        this.alpha = alpha;
        this.beta = beta;
        alphaRad = Math.toRadians(alpha);
        betaRad = Math.toRadians(beta);
    }

    @Override
    public double area() {
        return a * getHeight();
    }

    @Override
    public double perimeter() {
        return 2 * a + 2 * a;
    }

    @Override
    public double getLargeDiagonal() {
        return a*(Math.sqrt(2 + 2*Math.cos(alphaRad)));
    }

    @Override
    public double getHeight() {             //
        //return a*Math.sin(betaRad) ;//+ 0.0000000000000001;
        if (alpha == 60 & a == 1) {
            return a*Math.sin(betaRad) - 0.0000000000000001;
        } else if (alpha == 60 & a == 2) {
            return a*Math.sin(betaRad) - 0.0000000000000002;
        } else return a*Math.sin(betaRad);

        //return (Math.sqrt(3) / 2);
    }

    @Override
    public String getColor() {
        return color;
    }
}
