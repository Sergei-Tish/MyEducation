public class Vector2D extends Vector {
    public Vector2D(int x1, int y1, int x2, int y2) {
        super(x1, y1, 0, x2, y2, 0);
    }

    int vectorXCords = getX2() - getX1();
    int vectorYCords = getY2() - getY1();

    @Override
    public double getLength() {
        return Math.abs(Math.sqrt(vectorXCords * vectorXCords + vectorYCords * vectorYCords));
    }

    @Override
    public String getVectorCords() {
        // AB = {Bx - Ax; By - Ay} = {4 - 2; 3 - 3} = {2; 0}
        return vectorXCords + " " + vectorYCords;
    }

    double getScalarProduct(Vector2D vector2D) {
        return vectorXCords * vector2D.vectorXCords + vectorYCords * vector2D.vectorYCords;
    }

    double getAngle(Vector2D vector2D) {
        if (getLength() != 0 && vector2D.getLength() != 0) {
            return getScalarProduct(vector2D) / (getLength() * vector2D.getLength());
        }
        return -2.0;
    }
}
