import interfaces.Deletable;
import package1.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDelete {
    public static void main(String[] args) throws Exception {
        Article article = new Article();
        Picture picture = new Picture();
        deleteAll(article, picture, new Article(), new Picture());
//        List<Class> classList = MainDelete.getAllClasses();
//        System.out.println(classList);
    }

    public static void deleteAll(Deletable... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println("Now I delete all: " + Arrays.stream(args).count() + " args");
        for (Deletable deletable : args) {
            Method methodDelete = deletable.getClass().getDeclaredMethod("delete");
//            methodDelete.setAccessible(true);
            methodDelete.invoke(deletable, "dd2");
        }
    }
}
