create database carsdrivers;

create table if not exists engines (
                                       id serial primary key,
                                       name varchar(100)
);

create table if not exists drivers (
                                       id serial primary key,
                                       name varchar(100)
);

create table if not exists cars (
                                    id serial primary key,
                                    name varchar(100),
                                    engine_id int not null references engines(id)
);

create table if not exists cars_drivers (
                                            id serial primary key,
                                            driver_id int not null references drivers(id),
                                            car_id int not null references cars(id)
)