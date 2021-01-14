create table role (
    id serial primary key,
    role varchar(255)
);

create table rules (
    id serial primary key,
    rules text
);

create table username (
    id serial primary key,
    username text,
    role_id int references role(id)
);

create table role_rules (
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id)
);

create table state (
    id serial primary key,
    status boolean
);

create table category (
    id serial primary key,
    category text
);

create table item (
    id serial primary key,
    count int,
    item text,
    username_id int references username(id),
    category_id int references category(id),
    state_id int references state(id)
);

create table comments (
    id serial primary key,
    count int,
    comment text,
    item_id int references item(id)
);

create table attachs (
    id serial primary key,
    filename text,
    format varchar(255),
    item_id int references item(id)
);