import package1.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Delete {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Article article = new Article();
        Picture picture = new Picture();
        deleteAll(article, picture, new Article(), new Picture());


    }

    public static void deleteAll(Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println("Now I delete all: " + Arrays.stream(args).count() + " args");
        for (Object object : args) {
            Method methodDelete = object.getClass().getDeclaredMethod("delete");
            methodDelete.setAccessible(true);
            methodDelete.invoke(object);
        }
    }
}
