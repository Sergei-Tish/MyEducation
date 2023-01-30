public class Main {
    public static void main(String[] args) {
        Vector2D vector2D = new Vector2D(-4, 2, 9, 3);
        System.out.println(vector2D.getVectorCords());
        System.out.println(vector2D.getLength());
        Vector2D vector2D1 = new Vector2D(1, 5, 4, 9);
        System.out.println(vector2D1.getVectorCords());
        System.out.println(vector2D1.getLength());
        System.out.println(vector2D.getAngle(vector2D1));
        System.out.println(vector2D.getScalarProduct(vector2D1));
    }
}