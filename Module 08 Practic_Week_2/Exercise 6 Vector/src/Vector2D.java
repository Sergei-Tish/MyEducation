public class Vector2D extends Vector{
    public Vector2D(int x1, int y1, int x2, int y2) {
        super(x1, y1, 0, x2, y2, 0);
    }
    int vectorXCords = getX2() - getX1();
    int vectorYCords = getY2() - getY1();

    @Override
    double getLength() {
        return Math.abs(Math.sqrt(vectorXCords * vectorXCords + vectorYCords * vectorYCords));
    }

    @Override
    String getVectorCords() {
        // AB = {Bx - Ax; By - Ay} = {4 - 2; 3 - 3} = {2; 0}
        return vectorXCords + ", " + vectorYCords;
    }

    double getScalarProduct(Vector2D vector) {
        return getLength() * vector.getLength() * getAngle(vector);
    }

    double getAngle(Vector2D vector) {
        double abLength = vectorXCords * vector.vectorXCords + vectorYCords * vector.vectorYCords;
        double abModule = getLength() * vector.getLength();
        return abLength / abModule;
    }
}
