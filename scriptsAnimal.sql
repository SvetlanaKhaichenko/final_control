create database AllAnimals;
use AllAnimals;

create table typesAnimals (id_type int primary key auto_increment not null, name_type varchar (15));

insert into typesAnimals (name_type)
values 
('Cat'), ('Dog'), ('Hamster'), 
('Horse'), ('Camal'), ('Donkey');
select * from typesAnimals;

create table cats (id int primary key auto_increment not null, name varchar(15), type_id int, birthday date, commands varchar(150),
foreign key (type_id) references typesAnimals(id_type) on delete cascade);

insert into cats(name, type_id, birthday, commands)
values
('Tom', 1, '2022-06-21', 'Eat, Sit'),
('Lukky', 1, '2023-01-15', 'Down, Eat');

create table dogs (id int primary key auto_increment not null, name varchar(15), type_id int, birthday date, commands varchar(150),
foreign key (type_id) references typesAnimals(id_type) on delete cascade);

insert into dogs(name, type_id, birthday, commands)
values
('Frido', 2, '2024-01-20', 'Sit, Stay, Down'),
('Buddy', 2, '2021-08-04', 'Speak, Stay, Wait'),
('Oliver', 2, '2023-11-23', 'Stay, Roll, Paw');

create table hamsters (id int primary key auto_increment not null, name varchar(15), type_id int, birthday date, commands varchar(150),
foreign key (type_id) references typesAnimals(id_type) on delete cascade);

insert into hamsters(name, type_id, birthday, commands)
values
('Hammy', 3, '2024-08-12', 'Spin, Roll'),
('Slippy', 3, '2022-04-16', 'Roll, Hide');


create table horses (id int primary key auto_increment not null, name varchar(15), type_id int, birthday date, commands varchar(150),
foreign key (type_id) references typesAnimals(id_type) on delete cascade);

insert into horses(name, type_id, birthday, commands)
values
('Thandy', 4, '2019-02-18', 'Trot, Canter, Gallop'),
('Mandy', 4, '2023-07-19', 'Walk, Run'),
('Storm', 4, '2022-01-27', 'Trot, Jump');

create table donkeys(id int primary key auto_increment not null, name varchar(15), type_id int, birthday date, commands varchar(150),
foreign key (type_id) references typesAnimals(id_type) on delete cascade);

insert into donkeys(name, type_id, birthday, commands)
values
('Zakky', 6, '2019-03-24', 'Walk, Bray, Kick'),
('Burritos', 6, '2022-01-17', 'Walk, Run');

create table camals(id int primary key auto_increment not null, name varchar(15), type_id int, birthday date, commands varchar(150),
foreign key (type_id) references typesAnimals(id_type) on delete cascade);

insert into camals(name, type_id, birthday, commands)
values
('Sindy', 5, '2019-02-22', 'Walk'),
('Jack', 5, '2022-03-05', 'Wlak, Sit'),
('Figgi', 5, '2019-03-11', 'Walk, Run');

delete from camals where type_id=5;
select * from camals;

create table horses_donkeys (id int primary key auto_increment not null)
select name, type_id, birthday, commands from horses union select name, type_id, birthday, commands from donkeys;

select * from horses_donkeys;

create table AnimalsYearsOne_Tree (id int primary key auto_increment not null)
select name, type_id, birthday, commands, timestampdiff(year, cats.birthday, now()) as age from cats where timestampdiff(month, cats.birthday, now()) between 12 and 36
union select name, type_id, birthday, commands, timestampdiff(year, dogs.birthday, now()) as age from dogs where timestampdiff(month, dogs.birthday, now()) between 12 and 36
union select name, type_id, birthday, commands, timestampdiff(year, hamsters.birthday, now()) as age from hamsters where timestampdiff(month, hamsters.birthday, now()) between 12 and 36
union select name, type_id, birthday, commands, timestampdiff(year, hd.birthday, now()) as age from horses_donkeys as hd where timestampdiff(month, hd.birthday, now()) between 12 and 36;

select name, name_type, birthday, commands, age from AnimalsYearsOne_Tree as y 
inner join typesanimals as type on y.type_id=type.id_type;

create table AllAnimals (id int primary key auto_increment not null)
select name, type_id, birthday, commands from cats
union select name, type_id, birthday, commands from dogs
union select name, type_id, birthday, commands from hamsters
union select name, type_id, birthday, commands from horses
union select name, type_id, birthday, commands from camals
union select name, type_id, birthday, commands from donkeys;


select id, name, name_type, birthday, commands from allanimals as an 
inner join typesanimals as type on an.type_id=type.id_type;
