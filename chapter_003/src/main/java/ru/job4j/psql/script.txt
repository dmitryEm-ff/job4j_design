create database cars_db;

\c cars_db;

create table cars(
    id serial primary key,
    model text,
    manufactured varchar(255),
    horsepower int
    );

insert into cars(model, manufactured, horsepower) VALUES ('Mazda', 'JAP', 200);

select * from cars;

update cars set model = 'Lada', manufactured = 'RUS', horsepower = 50;

select * from cars;

delete from cars;

select * from cars;