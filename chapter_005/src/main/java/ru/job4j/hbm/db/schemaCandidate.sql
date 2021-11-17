create table if not exists vacancies (
    id serial primary key,
    description varchar(200)
);

create table if not exists vacancydb (
    id serial primary key,
    name varchar(200)
);

create table if not exists candidates (
    id serial primary key,
    name varchar(200),
    exp int,
    salary int,
    vacancy_db int not null references vacancydb(id)
);