Задание 19.3.1 {
        /**         Выполните запрос и убедитесь, что значение для колонки in_stock было установлено и равно 0.         */
     INSERT INTO products (name, price, category)
        VALUES
        ('Шампунь','120', 'косметика');             }
Задание 19.3.2 {
        /**         Напишите запрос, который добавит новый продукт:
         *  19, 'Набор посуды', 1400, 'товары для дома', 5                                                              */
        INSERT INTO products (id, name, price, category, in_stock)
            VALUES ( 19, 'Набор посуды',
                1400, 'товары для дома', 5 )
        ON CONFLICT (id) DO
            UPDATE
        SET
            id = excluded.id,
            name = EXCLUDED.name,
            price = EXCLUDED.price,
            category = EXCLUDED.category,
            in_stock = EXCLUDED.in_stock;           }
Задание 19.3.4 {
        /**         Напишите запрос, который возвращает название товара и сколько раз он был куплен.                    */
        select products.name,
            count(positions.amount)
        from products, positions
        where products.id = positions.product_id
        group by name;                              }
Задание 19.3.5 {
        /** Создайте таблицу с двумя колонками: имя товара и количество раз, сколько этот товар был куплен. С помощью запроса из предыдущего задания заполните её данными.  */
        create table products_count (
            name varchar(100) not null,
            full_count integer      );

        insert into products_count
            select
                products.name,
                count(positions.amount)
            from products, positions
            where products.id = positions.product_id
            group by name;                          }
Задание 19.3.8 {
        /**         Напишите запрос, который получает количество и название товаров, которые были в заказах Бук Василия Петровича.
         *      При этом необходимо убедиться, что заказ ещё не доставляется и не выполнен.                             */
        select products.name, positions.amount as "buy by Ivan"
        from  products, positions  /** можно было написать: JOIN positions ON products.id = positions.product_id  */
        where positions.order_id in (
            select orders.id
            from orders
            where orders.client_id = (
                select clients.id
                from clients
                where name in ('Бук Василий Петрович')
            ) and orders.status not in ('done', 'delivery')
        )
        and products.id = positions.product_id ;
        /** увеличение на 1 */ // Вариант 1                                     Вариант 2
        update positions                                                    UPDATE positions
        set amount = amount + 1                                             SET amount = amount + 1
        where order_id in (                                                 FROM orders
            select orders.id                                                WHERE orders.client_id = (
            from orders                                                         SELECT id
            where orders.client_id = (                                          FROM clients
            select clients.id                                                   WHERE name = 'Бук Василий Петрович'
                from clients                                                ) AND positions.order_id = orders.id;
                where name in ('Бук Василий Петрович')
            ) and orders.status not in ('done', 'delivery')
        );                                          }
Задание 19.3.9 {
        /**         Напишите запрос, который возвращает идентификаторы заказов, в которых был заказан велосипед.
         *      Кроме этого, пусть будет возвращено, сколько велосипедов было заказано в каждом заказе.                 */
        select positions.order_id, positions.amount
        from positions
        where positions.product_id = (
            SELECT id
            FROM products
            WHERE name = 'Велосипед горный' );      }
Задание 19.3.10 {
        /**         В каждом заказе, в котором был велосипед, увеличьте количество заказанных велосипедов на 1.
         *      То есть, если в заказе был один велосипед, то после выполнения запросов их должно стать 2 и т.д.
         *      Проверьте, что всё отработало корректно, с помощью запроса из предыдущего задания.                      */
        update positions
        set amount = amount + 1
        where product_id = 1;                       } /* = (SELECT id FROM products WHERE name = 'Велосипед горный' );  */
Задание 19.3.11 {
        /**         Напишите запрос, который возвращает имена всех клиентов, которые не совершали заказов.              */
        select * from clients
        where id not in (
            select orders.client_id
            from orders );                          }
Задание 19.3.12 {
        /**         Удалите из таблицы с клиентами всех клиентов, которые не совершали заказов.                         */
        delete from clients
        where id not in (
            select orders.client_id
            from orders );                          }
