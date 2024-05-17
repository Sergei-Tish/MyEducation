import interfaces.Deletable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Перепишите следующий код, используя метод invoke().
 * <p>
 * Deletable deletable = (Deletable) clazz.getConstructor().newInstance();
 * deletable.delete("s3d4");
 */

public class Main280303 {
    public static void main(String... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Article article = null;
        String articleId = "myId";
        Method methodDelete = article.getClass().getDeclaredMethod("delete", String.class);
        methodDelete.setAccessible(true);
        methodDelete.invoke(article, articleId);
    }
}


