create table student_groups (
	name varchar(255) not null,
    primary key (name)
) engine=InnoDB;

create table students (
	name varchar(255) not null,
    birth_year integer,
    student_group_name varchar(255),
    primary key (name)
) engine=InnoDB;

alter table students 
	add constraint FKojsafhli6hb96xn9e0alij3y8 
    foreign key (student_group_name) 
    references student_groups (name);
