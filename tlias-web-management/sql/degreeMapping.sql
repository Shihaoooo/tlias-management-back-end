create table degreeMapping(
    id tinyint unsigned primary key not null ,
    degree_name varchar(10) not null
);

insert into degreeMapping(id, degree_name)
values(1,'初中'),
      (2,'高中'),
      (3,'大专'),
      (4,'本科'),
      (5,'硕士'),
      (6,'博士');

drop table degreeMapping;