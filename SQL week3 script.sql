create database data_to_sell;
drop table if exists money_or_user;
drop table if exists post;
drop table if exists comment_;

create table money_or_user (
id int not null auto_increment,
username varchar (10) not null,
favorite_food varchar (20),
email varchar (20) not null,
password_ varchar (20) not null,
primary key (id)
);

create table post (
date_posted datetime default current_timestamp,
id int,
post_made varchar (280) not null, -- for this I looked up the max length of a post on twitter.
foreign key (id) references money_or_user (id),
primary key (date_posted)
);
 
 create table comment_ (
 date_commented datetime default current_timestamp,
 id int,
 comment_made varchar (280),
 foreign key (id) references money_or_user (id),
 foreign key (date_posted) references post (date_posted),
 primary key (date_commented)
 );
 