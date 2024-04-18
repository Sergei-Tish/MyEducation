import java.lang.reflect.*;
import java.util.*;

public class Main280201 {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
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
//        конструкторы у класса HashMap вызовем методм getConstructors().
        Constructor[] constructors = Class.forName("java.util.ArrayList").getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        System.out.println("\n поля у класса");
//        все поля класса получить с помощью метода getDeclaredFields()
        Field[] fields = Class.forName("java.util.ArrayList").getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("\n методы у класса");
//        описание всех методов класса можно получить с помощью метода getDeclaredMethods():
        Method[] methods = Class.forName("java.util.ArrayList").getDeclaredMethods();
//        Arrays.stream(methods).forEach(System.out::println); // тут описание, а ниже я их только посчитал для компактности вывода
        int countMethods = (int) Arrays.stream(methods).count();
        System.out.println("Количество методов у класса " + Class.forName("java.util.ArrayList")
                .getSimpleName() + " : " + countMethods);

        System.out.println("\n Java reflection можно не только получить информацию об объекте, но и создать новый объект. ");
        Constructor<?> constructorArrayList = Class.forName("java.util.ArrayList").getConstructor();
        List arrayList1 = (ArrayList) constructorArrayList.newInstance();
        System.out.println(arrayList1.getClass().getSimpleName());
        System.out.println(arrayList1.isEmpty());

        System.out.println("\n Также во время выполнения программы можно получать и задавать значения полям. \n" +
                " Рассмотрим следующий пример, демонстрирующий, почему с reflection нужно обращаться с осторожностью.");
        StudentForMain280201 instance = new StudentForMain280201().getClass().getConstructor().newInstance();
        Field field = instance.getClass().getDeclaredField("size");
        field.setAccessible(true); //Установим доступность поля
        field.setInt(instance, 10);

        System.out.println("Map is empty: " + instance.isEmpty());
        System.out.println("Map size:" + instance.size());
        System.out.println("Values: " + instance.toString());

        // не работает т.к. модуль java.base не открывает пакет java.util для неименованного модуля вашего приложения.
//        HashMap map = new HashMap(); //Создадим объект класса HashMap
//
//        Class<?> clazz = map.getClass(); //Получим у него класс
//
//        //Создадим новый объект класса HashMap
//        HashMap instance2 = (HashMap) clazz.getConstructor().newInstance();
//
//        //Получим у созданного объекта поле size
//        Field field2 = instance2.getClass().getDeclaredField("size");
//
//        //Установим доступность поля
//        field2.setAccessible(true);
//
//        //Установим полю size значение 10
//        field2.setInt(instance2, 10);
//
//        System.out.println("Map is empty: " + instance2.isEmpty());
//        System.out.println("Map size:" + instance2.size());
//        System.out.println("Values: " + instance2.toString());

        System.out.println("\n как вызвать методы с помощью Java reflection");
        HashMap map = new HashMap(); //Создаем объект класса HashMap
        Class clazz = map.getClass();         //Получаем объект класса Class у созданного объекта
        Method putMethod = clazz.getDeclaredMethod("put", Object.class, Object.class);        //У класса объекта получим метод put
        //Вызовем метод put. В качестве ключа укажем значение “key” и в качестве значения - “value”
        putMethod.invoke(map, "myKey", "myValue");
        putMethod.invoke(map, "dDd", "dddsdsd");
        System.out.println("Values: " + map.toString() + "; Map is empty: " + map.isEmpty() + "; Map size: " + map.size() + ";");
    }
}
