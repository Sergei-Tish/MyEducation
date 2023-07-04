public class Ex_18_03_01 {
    SELECT
    name AS "Название товара",
    price AS "Цена",
    category AS "Категория",
    in_stock AS "В наличии"
    FROM
            products;
}
public class Ex_18_03_02 {
    SELECT
    name AS "Название товара",
    price * in_stock AS "В наличии на сумму"
    FROM products;          }

public class Ex_18_04_11 {
        /**         Напишите запрос, который будет возвращать информацию о клиенте в следующем формате:
         * */
        select
        'Номер телефона ' || (name) || ': '
        ||
        CONCAT('+7-', SUBSTR(phone, 2, 3), '-', SUBSTR(phone, 5, 3), '-', SUBSTR(phone, 8, 2), '-', SUBSTR(phone, 10, 2)
        ) AS formatted_phone
        FROM clients;
        }
public class Задание 18.4.11 {
        /**         Напишите запрос, который будет скрывать часть номера телефона клиента, как описано в Задании 18.4.10.
         *      overlay \\ ИЛИ \\ substring + конкатенация                                                      */
    //substring + конкатенация
        select
        'Номер телефона ' || (name) || ': ' ||
        substring(phone from 1 for 4) || '***' || substring(phone from 8 for 4)
        AS formatted_phone
        FROM clients;
    //overlay
        select
        'Номер телефона ' || (name) || ': ' ||
        overlay(phone placing '***' from 5 for 3)
        AS formatted_phone
        FROM clients;                           }
public class Задание 18.4.12{
        /**         Какие id у заказов,города доставки которых заканчиваются на"ск"?                            */
        select id
        from orders
        where (address LIKE '%ск');             }
public class Задание 18.4.13{
        /**         Напишите запрос,который возвращает имена клиентов в номерах телефонов,в которых после 6следует 7,или наоборот.              */
        SELECT name FROM clients
        WHERE phone SIMILAR TO '%67%' OR phone similar to '%76%';
        /** ИЛИ */
        SELECT name FROM clients WHERE phone SIMILAR TO '%(67|76)%';        }
public class Задание 18.4.14{
        /**         В скольких номерах телефонов есть три или более цифры 4подряд?                              */
        select name FROM clients
        WHERE phone SIMILAR TO '%4{3,}%';       }
public class Задание 18.4.16 {
        /**         Напишите запрос, который возвращает название товаров, категория которых не определена.      */
        select name FROM products
        WHERE category is NULL;     }
public class Задание 18.5.1 {
        /**         Напишите запрос,который возвращает все категории товаров только один раз(значение NULL не должно быть возвращено в этом запросе).       */
        select DISTINCT category FROM products
        WHERE IS NOT NULL;          }
public class Задание 18.5.2 {
        /**         Напишите запрос, который выводит название "товаров для дома" по возрастанию их цены.        */
        select name FROM products
        where category = 'товары для дома'
        ORDER BY price DESC;
        /**         Обратите внимание, что нельзя использовать агрегатные функции в предложении WHERE, т.е. вот такой запрос не отработает:     */ /*
         SELECT name
         FROM products
         WHERE price = (select max(price) from poduct);     */
        /**         Такой запрос можно переписать с применением подзапроса вместо вызова функции max напрямую.  */      }
public class Задание 18.5.5 {
        /**         Составьте запрос, который подсчитывает среднюю стоимость товара в категории:                */
        select category
        ,
        avg(price) as avg_price
        from products
        group by category
        order by avg_price asc;     }
public class Задание 18.5.7 {
        /**         Напишите запрос, который возвращает информацию о том, сколько товаров выполнены, сколько товаров в доставке и в процессе обработки.
                    В подсчёте не должны участвовать товары, у которых город доставки — Казань (для этого вам понадобится where).               */
        SELECT orders.status, count(distinct order_id)
        from positions
        join orders on positions.order_id = orders.id
        WHERE address != 'Казань'
        group by orders.status
        order by count desc;        }
public class Задание 18.5.8 {
        /**         Составьте запрос,который выводит название категории,в которой находится самый дорогой товар.
                    Результат:Категория спорт.*/
        select category
        from products
        where price
        =
        (
        select max(price)
        from products
        )
        group by category;          }
public class Задание 18.5.9 {
        /**         Напишите запрос, который возвращает названия всех товаров, которые были в самом последнем (по дате) заказе.                 */
        select name
        from products
        where id IN (
            select product_id
            from positions
            where order_id IN (
                select id
                from orders
                where "date" = (
                    select max(date)
                    from orders
                )
            )
        );                          }
public class
        /**         INNER JOIN      результаты будут получены (FROM) из двух таблиц, которые соединены по условию, которое идёт после ON.       */
        /*           Ключевое слово INNER в запросе можно опустить.          */
            select *
            FROM orders
            JOIN clients on orders.client_id = clients.id;

        /**         CROSS JOIN      Декартово произведение двух множеств — это набор всех возможных пар из этих множеств.       */
            select *
            FROM orders
            CROSS JOIN clients;

        /**         OUTER JOIN
         Внешнее соединение бывает нескольких видов: FULL, LEFT, RIGHT.
         FULL OUTER JOIN), которое объединяет записи из обеих таблиц (если условие объединения равно true)
         и дополняет их всеми записями из обеих таблиц, которые не имеют совпадений.*/
            select *
            FROM orders
            FULL JOIN clients on orders.client_id = clients.id;         /**FULL*/

            select *
            FROM clients /* это левая таблица*/
            LEFT JOIN orders on orders.client_id = clients.id;          /**LEFT*/
         /**