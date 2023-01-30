public class Vector3D extends Vector {
    public Vector3D(int x1, int y1, int z1, int x2, int y2, int z2) {
        super(x1, y1, z1, x2, y2, z2);
    }

    int vectorXCords = getX2() - getX1();
    int vectorYCords = getY2() - getY1();
    int vectorZCords = getZ2() - getZ1();

    @Override
    public double getLength() {
        return Math.sqrt(vectorXCords * vectorXCords + vectorYCords * vectorYCords + vectorZCords * vectorZCords);
    }

    @Override
    public String getVectorCords() {
        // AB = {Bx - Ax; By - Ay; Bz - Az} = {4 - 2; 3 - 3; 2 - 4} = {2; 0; -2}
        return vectorXCords + " " + vectorYCords + " " + vectorZCords;
    }

    double getScalarProduct(Vector3D vector) {
        return vectorXCords * vector.vectorXCords + vectorYCords * vector.vectorYCords + vectorZCords * vector.vectorZCords;
    }
}
