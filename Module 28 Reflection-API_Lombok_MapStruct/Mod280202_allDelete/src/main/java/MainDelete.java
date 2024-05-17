import package1.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDelete {
    public static void main(String[] args) throws Exception {
        Article article = new Article();
        Picture picture = new Picture();
        deleteAll("sdsd", article.getClass(), picture.getClass());

        System.out.println();

        List<Class> classes = new ArrayList<>();
        classes.add(article.getClass());
        classes.add(picture.getClass());
        deleteAll("wwer", classes);
    }


    public static void deleteAll(String articleId, Class... classes)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        System.out.println("Now I delete all: " + Arrays.stream(classes).count() + " args");
        for (Class clazz : classes) {
            System.out.println(clazz);
            Method methodDelete = clazz.getDeclaredMethod("delete", String.class);
            methodDelete.setAccessible(true);
            methodDelete.invoke(clazz.getConstructor().newInstance(), articleId);
        }
    }
    public static void deleteAll(String articleId, List<Class> classes)
            throws ReflectiveOperationException {

        System.out.println("Now I delete all: " + classes.stream().count() + " args");
        for (Class clazz : classes) {
            System.out.println(clazz);
            Method methodDelete = clazz.getDeclaredMethod("delete", String.class);
            methodDelete.setAccessible(true);
            methodDelete.invoke(clazz.getConstructor().newInstance(), articleId);
        }
    }
}
