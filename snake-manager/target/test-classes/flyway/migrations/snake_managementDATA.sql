insert into users (user_id, user_name, email, password) values(null, 'Generic', 'generic@hotmail.com', 'slither');
insert into users (user_id, user_name, email, password) values(null, 'ScreamingBowl', 'bowl@hotmail.com', 'scale');

insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, 1, 'Hannibal', 'FEMALE', 'PANTHEROPHIS_GUTTATUS');
insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, 1, 'Russel', 'MALE', 'PANTHEROPHIS_GUTTATUS');
insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, 1, 'Penelope', 'FEMALE', 'PANTHEROPHIS_GUTTATUS');
insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, 2, 'Bubbles', 'FEMALE', 'PYTHON_REGIUS');
insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, 2, 'Darkrai', 'MALE', 'PYTHON_REGIUS');
insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, 2, 'October', 'MALE', 'PYTHON_REGIUS');
insert into snakes (snake_id, user_id, snake_name, sex, species) values(null, 2, 'Betty', 'FEMALE', 'PYTHON_REGIUS');

insert into food_type (food_type_id, food) values(null, 'Pinky Mouse');
insert into food_type (food_type_id, food) values(null, 'Fuzzy Mouse');
insert into food_type (food_type_id, food) values(null, 'Hopper Mouse');
insert into food_type (food_type_id, food) values(null, 'Small Mouse');
insert into food_type (food_type_id, food) values(null, 'Adult Mouse');
insert into food_type (food_type_id, food) values(null, 'Jumbo Mouse');
insert into food_type (food_type_id, food) values(null, 'Pinky Rat');
insert into food_type (food_type_id, food) values(null, 'Fuzzy Rat');
insert into food_type (food_type_id, food) values(null, 'Small Rat');
insert into food_type (food_type_id, food) values(null, 'Medium Rat');
insert into food_type (food_type_id, food) values(null, 'Large Rat');
insert into food_type (food_type_id, food) values(null, 'Jumbo Rat');

insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 1, '2022-06-04 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 2, '2022-06-04 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 3, '2022-06-04 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 4, '2022-06-04 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 5, '2022-06-04 00:00:00', 'NO');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 6, '2022-06-04 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 7, '2022-06-04 00:00:00', 'YES');

insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 1, '2022-05-28 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 2, '2022-05-28 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 3, '2022-05-28 00:00:00', 'YES');

insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 1, '2022-05-21 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 2, '2022-05-21 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 3, '2022-05-21 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 5, '2022-05-21 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 6, '2022-05-21 00:00:00', 'YES');
insert into feeding (feeding_id, snake_id, feed_timestamp, was_food_consumed) values(null, 7, '2022-05-21 00:00:00', 'YES');

insert into feeding_content (feeding_id, food_type_id, quantity) values(1, 6, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(2, 6, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(3, 2, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(4, 10, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(5, 10, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(6, 10, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(7, 9, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(8, 5, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(9, 5, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(10, 2, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(11, 5, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(12, 5, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(13, 2, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(14, 10, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(15, 10, 1);
insert into feeding_content (feeding_id, food_type_id, quantity) values(16, 9, 1);