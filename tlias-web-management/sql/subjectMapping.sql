create table subjectMapping(
    subject_id int ,
    subject_name varchar(20)
    )

insert into subjectMapping (subject_id, subject_name)
values(1,'Java后端开发'),
      (2,'Python数据分析'),
      (3, '大数据开发');

select * from subjectMapping;