create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) VALUES ('AndroidPhone', 10000);
insert into devices (name, price) VALUES ('iOSPhone', 15000);
insert into devices (name, price) VALUES ('Notebook', 35000);
insert into devices (name, price) VALUES ('Tablet', 12000);
insert into devices (name, price) VALUES ('Flashlight', 100);
insert into devices (name, price) VALUES ('Watch', 100);

insert into people (name) VALUES ('Ivan');
insert into people (name) VALUES ('Egor');
insert into people (name) VALUES ('Elena');
insert into people (name) VALUES ('Viktor');

insert into devices_people (device_id, people_id) VALUES (1, 1);
insert into devices_people (device_id, people_id) VALUES (3, 1);
insert into devices_people (device_id, people_id) VALUES (5, 1);
insert into devices_people (device_id, people_id) VALUES (6, 1);
insert into devices_people (device_id, people_id) VALUES (2, 2);
insert into devices_people (device_id, people_id) VALUES (3, 2);
insert into devices_people (device_id, people_id) VALUES (4, 3);
insert into devices_people (device_id, people_id) VALUES (5, 3);
insert into devices_people (device_id, people_id) VALUES (6, 3);
insert into devices_people (device_id, people_id) VALUES (1, 4);
insert into devices_people (device_id, people_id) VALUES (2, 4);
insert into devices_people (device_id, people_id) VALUES (3, 4);
insert into devices_people (device_id, people_id) VALUES (4, 4);

/*Средняя цена всех устройств в таблице devices*/
select avg(price) from devices;

/*Средняя цена всех устройств на руках у всех пользователей*/
select avg(d.price) from devices as d
    join devices_people on d.id = devices_people.device_id;

/*Средняя цена всех устройств на руках у каждого пользователя*/
select p.name ,avg(d.price) from devices_people as dp
    join devices d on dp.device_id = d.id
    join people p on dp.people_id = p.id
group by p.name;

/*Средняя цена всех устройств на руках у каждого пользователя выше 5000*/
select p.name ,avg(d.price) from devices_people as dp
    join devices d on dp.device_id = d.id
    join people p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;