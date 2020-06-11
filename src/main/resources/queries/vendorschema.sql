use projectdb;

create table vendor (
id int PRIMARY KEY,
code varchar(20),
name varchar(20),
type varchar(10),
email varchar(20),
phone varchar(15),
address varchar(80)
);

select * from vendor;

drop table vendor;