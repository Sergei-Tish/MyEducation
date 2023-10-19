import redis.clients.jedis.Jedis;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://localhost:6379");
        System.out.println(jedis.ping());

        System.out.println(jedis.set("TestKey", "TestValue"));
        System.out.println("Метод для проверки наличия индекса. Верный индекс: " + jedis.exists("TestKey") + ", неверный индекс: " + jedis.exists("FalseTestKey"));
        System.out.println(jedis.del("TestKey"));
        System.out.println("Метод для проверки наличия индекса. Верный индекс: " + jedis.exists("TestKey") + ", неверный индекс: " + jedis.exists("FalseTestKey"));
        jedis.set("TestKey", "TestValue");
        System.out.println("Метод для проверки наличия индекса. Верный индекс: " + jedis.exists("TestKey") + ", неверный индекс: " + jedis.exists("FalseTestKey"));


        System.out.println("Метод добавления словаря");
        System.out.println(jedis.hset("TestSetKey", "FieldFirstKey", "Value1"));
        System.out.println(jedis.hset("TestSetKey", "FieldSecondKey", "testvalue2"));
        //Вывод в результат в одного значения
        System.out.println(jedis.hget("TestSetKey", "FieldSecondKey"));

        System.out.println();

        //Карта всех значений
        Map<String, String> fields = jedis.hgetAll("TestSetKey");
        for (String field : fields.keySet()) {
            System.out.println(field);
            System.out.println(fields.get(field) + " ++\n");
        }

        System.out.println();

        //Вывод значения конкретно поля уже из полученного множества
        System.out.println(fields.get("FieldFirstKey"));
        System.out.println(fields.get("FieldSecondKey"));

        System.out.println();

        //Удаляем карту

        System.out.println(jedis.del("TestSetKey"));
        System.out.println(fields.get("TestSetKey"));

    }
}
