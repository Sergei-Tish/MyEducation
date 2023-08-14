
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
        END $$;                                             }

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
        end $$;                                                 }

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
        END $$;                                                 }
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
        end $$;                                                 }

Задание 20.4.8 { /**     Добавьте в таблицу с заказами поле date_changed.
        *       Записывайте туда текущее время каждый раз, когда меняется значение какого либо поля в строке. */
        alter table orders add column date_changed (date);
        create or replace procedure date_change_update (order_id_input int) as
        $$
        begin
            execute ('UPDATE orders SET date_changed = now() WHERE orders.id = order_id_input');
        end $$ lenguage 'plpgsql';

        create or replace trigger update_order_date
        after update on orders
        execute procedure date_change_update();                 }
/** RIGHT VERSION */
Задание 20.4.8 {
            /** Добавьте в таблицу с заказами поле date_changed. Записывайте туда текущее время каждый раз, когда меняется значение какого либо поля в строке. */
        // alter table orders add column date_changed TIMESTAMP default '2023-01-01 00:00:00';
         create or replace FUNCTION date_change_update () RETURNS TRIGGER AS
        $$
            BEGIN
                NEW.date_changed = now();
                RETURN NEW;
            end;
        $$ language 'plpgsql';

        create or replace trigger update_order_date
                BEFORE update on orders
                for each row
            execute procedure date_change_update();

        /**     проверка работает ли */
        insert into orders (client_id, date, status, address)
            values (4, '2021-02-02', 'in progress', 'Барнаул');
        UPDATE orders
            set status = 'delivery'
        where id = 17;                                         }

Задание 20.5.1 - Напишите запрос, который получает название категории и среднюю стоимость товаров в ней.
    select category, avg(price)
    from products
    group by category ;


Предложение WITH - на примере 20.5.1
    WITH avg_prices AS (
        SELECT category,
        AVG(price) AS avg_price
        FROM products
        GROUP BY category
    )
    SELECT
        MAX(avg_price)
    FROM
        avg_prices;

Задание 20.5.2  /** Напишите запрос, который возвращает идентификаторы клиентов и среднюю стоимость их заказов.        */
        select client_id, avg(order_sum.order_price) as avg_order_price
        from (
            select pos.order_id, sum(pos.amount * prod.price) as order_price
            from positions pos
                join products prod on prod.id = pos.product_id
            group by pos.order_id
        ) as order_sum
            JOIN orders on orders.id = order_sum.order_id
        group by client_id
        order by avg_order_price desc;

Задание 20.5.3 /** - Перепишите */ Задание 20.5.2 /** с использованием WITH следующий запрос:                           */
        WITH order_sum as (
            SELECT pos.order_id, sum(pos.amount * prod.price) as order_price
            FROM positions pos
                JOIN products prod on prod.id = pos.product_id
            group by pos.order_id
        )
        SELECT
            client_id,
            avg(order_sum.order_price) as avg_order_price
        FROM
            order_sum
        JOIN
            orders on orders.id = order_sum.order_id
        group by client_id
        order by avg_order_price desc;









Модель 20 часть 6. /**      Итоговое задание
        *    Давайте разработаем базу данных системы для бронирования отелей.       */
    create table hotels (
    	id serial primary key,
    	name varchar(30) not NULL,
    	address varchar (100) not NULL,
    	rating int default 'no data');
    create table room_type (
    	id serial primary key,
    	hotel_id int not null references hotels(id),
    	name varchar(30) not null
    		check (name in ('lux', 'comfort', 'econom'))
    		?????,
    	total_count int not null
    		check (total_count >= 0)
    		????????,
    	price_per_night money not null
    		constraint positive_price_per_night
    			check (price_per_night >= 0 :: money),
    	number_of_beds int
    		check (number_of_beds >= 0 and nuber_of_beds <= 30),
    	description varchar(200)
    );
    create table clients (
    	id serial primary key,
    	first_name varchar(30) not null,
    	surname varchar(30) not null,
    	second_name varchar(30),
    	passport_number varchar(30)
    );
    create table reservations (
    	id serial primary key,
    	client_id int not null references clients(id),
    	room_type_id int not null references room_type(id),
    	from date not null,
    	to date,
    	status varchar(30) not null
    		constraint status_check check (
    			status in ('PAYMENT_PENDING', 'PAID', 'CANCELLED', 'CLOSED'))
    );
    create table services (
    	id serial primary key,
    	name varchar(30) not null,
    	price money
    		check (price >= 0)
    );
    create table service_booked (
    	reservation_id int references reservations(id),
    	service_id int references services(id)
    );


/* */
INSERT INTO hotels (name, address, rating)
VALUES
	('Центр-Отель', 'г. Симферополь, ул. Горького, 19', 8),
	('Plasa', 'г. Город, ул. Ленина, 1', 9),
	('Hostel Fun', 'г. Урюпинск, ул. Задворкина, 153б', 6),
	('Amparo', 'Mexico, San Miguel de Allende', 10),
	('у бабы Люды', 'Крым, г. Ялта, ул. Лесная, 11', 3),
	('Hilton Leningradskaya', 'Каланчёвская ул., 21/40', 8)
;

/* 	остальные таблицы заполнены как на сайте указали */

Задание 20.6.7
	Напишите запрос, который возвращает информацию обо всех бронированиях за 2019 год.
		select *
		from reservations
		where
			start_date >= '2019-01-01' AND start_date <= '2019-12-31';

Задание 20.6.8
	Напишите запрос, который будет возвращать имена клиентов и названия отелей, в которых они когда-либо осуществляли бронирование.
	/** я перемудрил */
	{with cl_rt AS (
		select cl.id as client_id, res.room_type_id
		from clients cl
			join reservations res on cl.id = res.client_id
	)
	select distinct
		cl.first_name as client_name,
		cl.surname as client_surname,
		hot.name as hotel_name
	from room_type rt
		join cl_rt on rt.id = cl_rt.room_type_id
		join clients cl on cl.id = cl_rt.client_id
		join hotels hot on hot.id = rt.hotel_id
	;}
	/** ответ из учебника */
{ 	SELECT
	  clients.first_name,
	  clients.second_name,
	  clients.surname,
	  hotels.name AS hotel
	FROM
	  reservations
	  JOIN clients ON client_id = clients.id
	  JOIN room_type ON room_type_id = room_type.id
	  JOIN hotels ON room_type.hotel_id = hotels.id;
}

Задание 20.6.9
			Напишите запрос, который будет возвращать имя отеля и суммарную стоимость заказанных сервисов в нём.
		Например, если в отеле было заказано три ужина, и каждый стоил по 20 рублей, то
		для этого отеля будет возвращено значение 60.
	select
		h."name" ,
		sum(s.price)
	from
		hotels h
		join room_type rt on rt.hotel_id = h.id
		join reservations r on r.room_type_id = rt.id
		join services_booked sb on sb.reservation_id = r.id
		join services s on s.id = sb.service_id
	group by h.id;


Задание 20.6.10
			Напишите запрос, который будет возвращать имя отеля и количество завершённых (closed) заказов в нём.

	select
		h."name",
		count(r.status)
	from
		hotels h
		join room_type rt on rt.hotel_id = h.id
		join reservations r on r.room_type_id = rt.id
		join services_booked sb on sb.reservation_id = r.id
		join services s on s.id = sb.service_id
		join clients c on c.id = r.client_id
	where r.status = 'CLOSED'
	group by h."name";


Задание 20.6.11
			Напишите запрос, который возвращает информацию обо всех сервисах, которые бронировал Василий Сергеевич Пупкин.

	select
		c.first_name,
		c.second_name ,
		c.surname ,
		s.*
	from
		hotels h
		join room_type rt on rt.hotel_id = h.id
		join reservations r on r.room_type_id = rt.id
		join services_booked sb on sb.reservation_id = r.id
		join services s on s.id = sb.service_id
		join clients c on c.id = r.client_id
	where c.surname in ('Пупкин')
	group by
		c.first_name, c.second_name, c.surname, s.id;



Задание 20.6.12
			Создайте представление для запроса, который возвращает информацию обо всех заказах отеля "Центр-Отель".

	create view orders_hotel_id1 AS
	select
		r.*
	from
		hotels h
		join room_type rt on rt.hotel_id = h.id
		join reservations r on r.room_type_id = rt.id
		join services_booked sb on sb.reservation_id = r.id
		join services s on s.id = sb.service_id
		join clients c on c.id = r.client_id
	where h."name" like 'Центр-Отель'
	group by
		r.id;


Задание 20.6.13
			Напишите запрос, который изменит статус всех бронирований с PAID на CLOSED.

	update
		reservations as r
 	set
 		r.status = 'CLOSED'
	where
		r.status = 'PAID';










