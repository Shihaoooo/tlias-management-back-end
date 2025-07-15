# 班级表
create table clazz(
                      id   int unsigned primary key auto_increment comment 'ID,主键',
                      name  varchar(30) not null unique  comment '班级名称',
                      room  varchar(20) comment '班级教室',
                      begin_date date not null comment '开课时间',
                      end_date date not null comment '结课时间',
                      master_id int unsigned null comment '班主任ID, 关联员工表ID',
                      subject tinyint unsigned not null comment '学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6: 嵌入式',
                      create_time datetime  comment '创建时间',
                      update_time datetime  comment '修改时间'
)comment '班级表';

INSERT INTO clazz VALUES (1,'JavaEE就业163期','212','2024-04-30','2024-06-29',10,1,'2024-06-01 17:08:23','2024-06-01 17:39:58'),
                         (2,'前端就业90期','210','2024-07-10','2024-01-20',3,2,'2024-06-01 17:45:12','2024-06-01 17:45:12'),
                         (3,'JavaEE就业165期','108','2024-06-15','2024-12-25',6,1,'2024-06-01 17:45:40','2024-06-01 17:45:40'),
                         (4,'JavaEE就业166期','105','2024-07-20','2024-02-20',20,1,'2024-06-01 17:46:10','2024-06-01 17:46:10'),
                         (5,'大数据就业58期','209','2024-08-01','2024-02-15',7,3,'2024-06-01 17:51:21','2024-06-01 17:51:21'),
                         (6,'JavaEE就业167期','325','2024-11-20','2024-05-10',36,1,'2024-11-15 11:35:46','2024-12-13 14:31:24');


select clazz.id,clazz.name, room, begin_date, end_date, master_id, clazz.create_time, clazz.update_time,emp.name as master_name,
       (case when current_date < clazz.begin_date then '未开课'
           when current_date > clazz.end_date then '已节课'
           else '在读中' end) as 'status'
from clazz left join emp
    on clazz.master_id=emp.id
where clazz.name like concat('%','java','%') and begin_date > '2023-01-01';
;


select * from clazz;
