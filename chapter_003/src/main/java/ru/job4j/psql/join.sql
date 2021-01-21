--1. Создать таблицы и заполнить их начальными данными

create table departments (
   id serial primary key,
   name text
);

create table emploees (
    id serial primary key,
    name text,
    department_id int references departments(id)
);

insert into departments(name) values ('engineers');
insert into departments(name) values ('buh');
insert into departments(name) values ('admins');

insert into emploees(name, department_id) values ('Vasya', 1);
insert into emploees(name, department_id) values ('Igor', 3);
insert into emploees(name, department_id) values ('Ignat', 1);
insert into emploees(name, department_id) values ('Lena', 2);
insert into emploees(name, department_id) values ('Sasha', 2);
insert into emploees(name, department_id) values ('Julia', 1);

insert into emploees(name) values ('Dasha');
insert into emploees(name) values ('Ilysha');

--2. Выполнить запросы с left, rigth, full, cross соединениями

select * from emploees e left join
  departments d on e.department_id = d.id;

select * from emploees e right join
  departments d on e.department_id = d.id;

select * from emploees e cross join departments d;

--3. Используя left join найти работников, которые не относятся ни к одну из департаментов

select * from emploees e left join departments d on e.department_id = d.id
where d.id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат.

select * from emploees e left join departments d on e.department_id = d.id;
select * from departments d right join emploees e on e.department_id = d.id;

/*5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
Используя cross join составить все возможные разнополые пары*/

create table teens (
    id serial primary key,
    name text,
    gender char
);

insert into teens(name, gender) VALUES ('Vasya', 'M');
insert into teens(name, gender) VALUES ('Ira', 'F');
insert into teens(name, gender) VALUES ('Pavel', 'M');
insert into teens(name, gender) VALUES ('Luda', 'F');

select  (n.name, n.gender) as person1, (g.name, g.gender) as person2
from teens n cross join teens g;