create database if not exists snake_manager;

use snake_manager;

drop table if exists users;
drop table if exists snakes;
drop table if exists feeding;
drop table if exists feeding_content;
drop table if exists food_type;

create table users (
	user_id int(11) not null auto_increment,
	user_name varchar(20) not null,
    email varchar(64) not null,
	password varchar(60) not null,
    primary key (user_id)
);

create table snakes (
	snake_id int(20) not null auto_increment,
    user_id int(11) not null,
    snake_name varchar(30) not null,
    sex enum('MALE', 'FEMALE') NOT NULL,
    species enum('PYTHON_REGIUS', 'PANTHEROPHIS_GUTTATUS', 'BOA_CONSTRICTOR', 'HETERODON_NASICUS', 'GONGYLOPHIS_COLUBRINUS', 'EPICRATES_CENCHRIA', 'MALAYOPYTHON_RETICULATUS', 'MORELIA_SPILOTA', 'OTHER') not null,
    primary key (snake_id),
    foreign key (user_id) references users (user_id)
);

create table feeding (
	feeding_id int(20) not null auto_increment,
    snake_id int(20) not null,
    feed_timestamp timestamp not null default CURRENT_TIMESTAMP,
    was_food_consumed enum('YES', 'NO', 'Regurgitated'),
	primary key (feeding_id),
    foreign key (snake_id) references snakes (snake_id)
);

create table food_type (
	food_type_id int(20) not null auto_increment,
    food varchar(64) not null,
	primary key (food_type_id)
);

create table feeding_content (
	feeding_id int(20) not null,
    food_type_id int(20) not null,
    quantity int(2) not null,
	foreign key (feeding_id) references feeding (feeding_id),
    foreign key (food_type_id) references food_type (food_type_id)
);
