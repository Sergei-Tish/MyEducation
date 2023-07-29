
                    /**         20.1. Индексы           */

Задание 20.1.2 {
        /**     Создайте составной индекс (категория и цена) для таблицы с продуктами.                                  */
        CREATE INDEX indx_categ_prc ON products(category,price);                                                    }

Задание 20.1.3 {
        /**     Создайте упорядоченный по убыванию индекс(по дате)для заказов.Значения NULL должны быть на первом месте.*/
        create index indx_orders_date on orders(date desc nulls first);                                             }

                    /**         20.2. Триггеры          */
Задание 20.2.1 {
        /**     Напишите код, который создаёт построчный BEFORE триггер для описанной выше функции.                     */
        CREATE TRIGGER emp_stamp BEFORE INSERT OR UPDATE
            ON emp FOR EACH ROW EXECUTE PROCEDURE emp_stamp();                                                      }

                    /**         20.3. Представления      */
Задание 20.3.1 и Задание 20.3.2{
        /**     Создайте ПРЕДСТАВЛЕНИЕ для запроса который будет возвращать название товара, количество в заказе,
        номер заказа для всех невыполненных и не отправленных на доставку заказов с адресом отправления Казань          */
        CREATE VIEW orders_to_kazan_inProgress as
        SELECT products."name",
            positions.order_id,
            positions.amount
        FROM products
        JOIN positions on positions.product_id = products.id
        where positions.order_id in (
            select id from orders
            where address = 'Казань'
                and status = 'in progress' );                                                                       }
Задание 20.3.4 и Задание 20.3.5 {
        /**     Создайте ПРЕДСТАВЛЕНИЕ для запроса который возвращает номер заказа и его полную стоимость.
         *  Например, если в заказе с идентификатором 1 было 3 товара стоимостью 1000 рублей каждый,
         *  то стоимость заказа будет 3000 рублей.                                                                      */

        CREATE VIEW orders_price AS
        SELECT orders.id, sum(positions.amount * products.price) as total_price
        FROM orders
            JOIN positions ON orders.id = positions.order_id
            JOIN products ON positions.product_id = products.id
        GROUP BY orders.id;                                                                                         }
Задание 20.3.6 {
        /**     Получите из представления максимальную стоимость заказа.                                                */
        SELECT max(total_price)
        FROM orders_price;                                                                                          }
Задание 20.3.7 {
        /**     Напишите запрос, который возвращает суммарное количество и имя для каждого товара,
         *  который приобрёл клиент с идентификатором 5.                                                                */
        select sum(positions.amount) as "sum_amount",
            products."name"
        from positions
            join products on products.id = positions.product_id
        where positions.order_id IN (
            select id from orders
            where orders.client_id = 5)
        group by products."name";                                                                                   }
Задание 20.3.8 {
        /**     Cоздайте материализованное представление для этого запроса.                                             */
        CREATE MATERIALIZED VIEW products_for_5 AS
        "+ Задание 20.3.7"                                                                                          }

Задание 20.4.1 {
        "Для того чтобы просто выполнить код на языке PL/pgSQL, без объявления процедуры, используется do-блок:"
        DO $$ DECLARE i INTEGER;
        BEGIN FOR i IN 1..10
            LOOP EXECUTE (
                'create table temp_table_' || i || '(id int, title varchar(100));'
            );
            END LOOP;
        END $$;

                    /**     Напишите код, который удалит созданные таблицы. */
        DO $$ DECLARE i INTEGER;
        BEGIN FOR i IN 1..10
            LOOP EXECUTE (
                'DROP table temp_table_' || i || ';'
            );
            END LOOP;
        END $$;

                /**     Давайте создадим процедуру с именем create_table: */
        CREATE OR REPLACE
            PROCEDURE create_table(name TEXT) AS $$ BEGIN EXECUTE (
                'create table ' || name || '(str varchar(100));'
            );
        END $$ LANGUAGE 'plpgsql';
                /**     Для того чтобы вызвать процедуру, используется инструкция CALL: */
         DO $$ BEGIN CALL create_table('tmp_table' :: TEXT);
        END $$;

Задание 20.4.3 {
        Напишите хранимую процедуру со следующей логикой работы:

        1./** Объявите локальную переменную типа TEXT.                                              */
        2./** В качестве аргумента процедура должна принимать имя таблицы.                          */
        3./** Первым действием удалите таблицу с таким именем, если она уже существует.             */
        4./** После этого создайте таблицу с указанным именем и одним столбцом типа varchar(100).   */
        5./** Вызовите функцию gen_abra_cadabra и результат сохраните в локальной переменной.       */
        6./** Для наглядности можете напечатать в output значение переменной.                       */
        7./** Добавьте значение из локальной переменной в базу с помощью команды INSERT.            */
        8./** Вызовите созданную процедуру и убедитесь, что она отработала правильно.               */


        create or replace procedure my_create_table (input_text TEXT) as
        $$
        declare local_text TEXT;
        begin
            execute ('drop table if exists '|| input_text || ';');
            execute ('create table '|| input_text || ' (str varchar(100));');
            local_text = gen_abra_cadabra(20);
            RAISE notice '%', local_text;
            execute ('insert into '|| input_text || ' (str)
                values (''' || local_text || ''');');
        end $$ language 'plpgsql';

        do $$ begin
            call my_create_table('my_table_name');
        end $$;

Задание 20.4.4,5 {
        DO $$ DECLARE rec RECORD;
        BEGIN FOR rec IN
        SELECT id, name, phone
        FROM clients
        ORDER BY name DESC
        LOOP
            RAISE NOTICE 'id = %, name = %, phone = %',
                rec.id,
                rec.name,
                rec.phone;
        END LOOP;
        END $$;                                             }
        /** Конструкция FOR ... IN ... LOOP в PostgreSQL используется для итерации по результатам выполнения запроса.   */

Задание 20.4.5 Что делает код ниже? {
        DO $$ DECLARE r RECORD;
        cnt INT;
        BEGIN FOR r IN
        SELECT address
        FROM orders
        WHERE
            status = 'in progress' LOOP EXECUTE 'select count(*) cnt FROM ' || r.address INTO cnt;
        RAISE NOTICE '% %',
            r.address,
            cnt;
        END LOOP;
        END $$;                                                 }
        /**         Печатает имена таблиц в схеме public и количество записей в них                 */

Задание 20.4.7 Удалите все процедуры и функции, которые были созданы в рамках модуля. {
        do $$ begin
            drop procedure create_table;
            drop procedure my_create_table;
            drop function check_in_stock;
            drop function gen_abra_cadabra;
        end $$;                                             }







