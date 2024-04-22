import interfaces.Deletable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main280304 {
    public static void main(String[] args) throws Exception {
        //Получаем все классы в пакетe - чёт не работает у меня :(. Упростил метод.
        List<Class> classes = getAllClasses();

        for (Class clazz : classes) {
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getMethods();
            for (Field field : fields) {
                int modifier = field.getModifiers();
                if (!Modifier.isPrivate(modifier))
                    System.out.println("Field with name \"" + field.getName() + "\" should be private");

                String fieldName = field.getName();
                String setterName = "set" +
                        fieldName.substring(0, 1).toUpperCase() +
                        fieldName.substring(1);
                String getterName = "get" +
                        fieldName.substring(0, 1).toUpperCase() +
                        fieldName.substring(1);

                boolean hasSetter = false;
                boolean hasGetter = false;
                for (Method method : methods) {
                    if (method.getName().equals(setterName)) {
                        hasSetter = true;
                    }
                }
                hasGetter = Arrays.stream(methods).anyMatch(method -> method.getName().equals(getterName));
                if (!hasSetter) System.out.println("Author has no setter for \"" + fieldName+ "\"");
                if (!hasGetter) System.out.println("Author has no getter for \"" + fieldName+ "\"");
            }

        }

    }

    public static List<Class> getAllClasses() throws Exception {
        List<Class> classes = new ArrayList<>();
//        URL upackage = Main280304.class.getClassLoader().getResource("");
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            classes.add(Class.forName(line.replace(".class", "")));
//        }
        Article article = new Article();
        Author author = new Author();
        classes.add(article.getClass());
        classes.add(author.getClass());
        return classes;
    }
}
