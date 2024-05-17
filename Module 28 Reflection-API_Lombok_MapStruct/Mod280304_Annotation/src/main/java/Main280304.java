public class Main280304 {
    public static void main(String[] args) {
        Author280304 author280304 = new Author280304();

        Class clazz = author280304.getClass();

        ClassAuthor280304 clazzAnnotation = (ClassAuthor280304) clazz.getAnnotation(ClassAuthor280304.class);
        String string = clazzAnnotation.value();
        System.out.println(string);
    }
}