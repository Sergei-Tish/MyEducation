
                    /**         20.1. Индексы           */

Задание 20.1.2 {
        /** Создайте составной индекс (категория и цена) для таблицы с продуктами.                                      */
        CREATE INDEX indx_categ_prc ON products(category,price);                                                        }

Задание 20.1.3 {
        /** Создайте упорядоченный по убыванию индекс(по дате)для заказов.Значения NULL должны быть на первом месте.    */
        create index indx_orders_date on orders(date desc nulls first);                                                 }
                    /**         20.2. Триггеры          */
Задание 20.2.1 {
        /** Напишите код, который создаёт построчный BEFORE триггер для описанной выше функции.                         */
        CREATE TRIGGER emp_stamp BEFORE INSERT OR UPDATE
            ON emp FOR EACH ROW EXECUTE PROCEDURE emp_stamp();                                                          }
                    /**         20.3. Представления      */








