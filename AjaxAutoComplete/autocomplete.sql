drop table if exists t_ajax;
create table t_ajax(
    id int primary key  auto_increment,
    content varchar (255)
);
insert into t_ajax(content) value ('javascript');
insert into t_ajax(content) value ('javaweb');
insert into t_ajax(content) value ('sql');
insert into t_ajax(content) value ('mysql');
insert into t_ajax(content) value ('myapp');
insert into t_ajax(content) value ('jdk');
insert into t_ajax(content) value ('yang');
commit;
select  * from t_ajax;