create table event(
	id integer(10) unsigned auto_increment primary key,
	name varchar(128) not null,
	date_ date not null,
	location text not null,
	avail_status varchar(10) not null,
	category varchar(10) not null,
	description text not null
)engine=innodb;