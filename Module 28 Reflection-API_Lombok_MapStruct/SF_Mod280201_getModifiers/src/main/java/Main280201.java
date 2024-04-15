import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main280201 {
    public static void main(String[] args) throws ClassNotFoundException {
//        Имеет ли ArrayList модификаторы public или protected.
//        Имеет ли AbstractList модификаторы static или abstract.
//        Является ли Collection интерфейсом.
        List arrayList = new ArrayList();
        Class arrayListClass = Class.forName("java.util.ArrayList");
        Class abstractListClass = Class.forName("java.util.AbstractList");
        Class collectionClass = Class.forName("java.util.Collection");

        int arrayListModifiers = arrayListClass.getModifiers();
        int abstractListModifiers = abstractListClass.getModifiers();
        int collectionModifiers = collectionClass.getModifiers();

        //Выводим, имеют ли ArrayList AbstractList Collection селдующие модификаторы
        System.out.println("ArrayList class is public :" + Modifier.isPublic(arrayListModifiers));
        System.out.println("ArrayList class is protected :" + Modifier.isProtected(arrayListModifiers));
        System.out.println("AbstractList class is static :" + Modifier.isStatic(abstractListModifiers));
        System.out.println("AbstractList class is abstract :" + Modifier.isAbstract(abstractListModifiers));
        System.out.println("Collection class is interface :" + Modifier.isInterface(collectionModifiers));

        System.out.println("\n имя пакета класса");
//        у класса вызовем метод getPackage(). Выведем на экран имя, полученного пакета.
        Package arrayListClassPackage = arrayListClass.getPackage();
        System.out.println("ArrayList package is : " + arrayListClassPackage.getName());

        System.out.println("\n родительский класс класса");
//        Чтобы получить информацию о родительском классе достаточно вызвать метод getSuperclass()
        Class arrayListSuperclass = Class.forName("java.util.ArrayList").getSuperclass();
        System.out.println("ArrayList superclass is : " + arrayListSuperclass.getSimpleName());
        Class arrayListSuperclassSuperclass = arrayListSuperclass.getSuperclass();
        System.out.println("Superclass of ArrayList superclass  is : " + arrayListSuperclassSuperclass.getSimpleName());
        Class arrayListSuperclassSuperclassSuperClass = arrayListSuperclassSuperclass.getSuperclass();
        System.out.println("Superclass of superclass of ArrayList superclass  is : " + arrayListSuperclassSuperclassSuperClass.getSimpleName());

        System.out.println("\n интерфейсы класса");
//        Выведем на экран все интерфейсы класса ArrayList
        Class[] interfacesArrayList = Class.forName("java.util.ArrayList").getInterfaces();
        Arrays.stream(interfacesArrayList).forEach(System.out::println);

//        Конструкторы, методы и поля

        System.out.println("\n конструкторы у класса");
//        Рассмотрим какие есть конструкторы у класса HashMap. вызовем метод getConstructors().
        Constructor[] constructors = Class.forName("java.util.ArrayList").getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        System.out.println("\n поля у класса");
//        Все поля класса можем получить с помощью метода getDeclaredFields()
        Field[] fields = Class.forName("java.util.ArrayList").getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("\n методы у класса");
//        описание всех методов класса можно получить с помощью метода getDeclaredMethods():
        Method[] methods = Class.forName("java.util.ArrayList").getDeclaredMethods();
        int countMethods = (int) Arrays.stream(methods).count();
        System.out.println("Количество методов у класса " + Class.forName("java.util.ArrayList").getSimpleName() + " : " + countMethods);
    }
}
