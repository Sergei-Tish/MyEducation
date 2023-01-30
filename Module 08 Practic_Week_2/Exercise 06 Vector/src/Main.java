public class Main {
    public static void main(String[] args) {
        Vector2D vector2D = new Vector2D(0, 0, 1, 1);
        Vector2D vector2D1 = new Vector2D(0, 0, 3, 2);
        System.out.println(vector2D.getVectorCords());
        System.out.println(vector2D.getLength());
        System.out.println(vector2D1.getVectorCords());
        System.out.println(vector2D1.getLength());
        System.out.println(vector2D.getAngle(vector2D1));
        System.out.println(vector2D.getScalarProduct(vector2D1));
        System.out.println();
        Vector3D vector3D = new Vector3D(0,0,0,1,1,1);
        Vector3D vector3D1 = new Vector3D(0,0,0,3,2,0);
        System.out.println(vector3D.getVectorCords());
        System.out.println(vector3D.getLength());
        System.out.println(vector3D1.getVectorCords());
        System.out.println(vector3D1.getLength());
        System.out.println(vector3D.getScalarProduct(vector3D1));
    }
}