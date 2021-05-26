create database CarPark;

create table car(
    id serial primary key,
    name varchar(255),
    hp int,
    mileage int
);

create table driver(
    id serial primary key,
    name varchar(255),
    experience int,
    hired boolean,
    car_id int references car(id)
);

insert into car(name, hp, mileage) VALUES ('lada', 70, 150000);
insert into car(name, hp, mileage) VALUES ('bmw', 150, 30000);
insert into car(name, hp, mileage) VALUES ('audi', 100, 68000);
insert into car(name, hp, mileage) VALUES ('bmw', 150, 30000);

insert into driver(name, experience, hired, car_id) VALUES ('Igor', 5, false, 2);
insert into driver(name, experience, hired, car_id) VALUES ('Dimitry', 1, false, 3);
insert into driver(name, experience, hired, car_id) VALUES ('Ivan', 10, true, 1);
insert into driver(name, experience, hired, car_id) VALUES ('Alex', 3, false, 4);
insert into driver(name, experience, hired, car_id) VALUES ('Egor', 2, false, 2);
insert into driver(name, experience, hired, car_id) VALUES ('Vera', 8, false, 1);
insert into driver(name, experience, hired, car_id) VALUES ('Inna', 5, true, 3);

select pp.name, p.name from driver as pp join car as p on pp.car_id = p.id;

select pp.name as Водитель, pp.experience as Стаж, p.name as Авто, p.mileage as Пробег
from driver as pp join car as p on pp.car_id = p.id;

select p.name, p.hp, pp.name, pp.hired from car as p join driver as pp on p.id = pp.car_id
where hired != true;