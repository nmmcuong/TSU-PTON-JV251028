create database db_degree__management;
use db_degree__management;

create table degrees (
degree_id int primary key auto_increment,
degree_name VARCHAR(150) NOT NULL,
emp_id VARCHAR(15) NOT NULL,
degree_date DATETIME NOT NULL,
school_nname VARCHAR(100) NOT NULL,
degree_year INT  NOT NULL ,
degree_classification VARCHAR(20)  NOT NULL
)

--Procedure thực hiện lấy danh sách tất cả các bằng cấp.
delimiter $$
create procedure get_all_degree()
begin
select * from drgree;
end $$
delimiter ;

#Procedure thực hiện thêm mới một b bằng cấp.
delimiter $$
create procedure sp_insert_degree(
    in p_degree_name VARCHAR(150),
	in p_emp_id VARCHAR(15) ,
	in p_degree_date DATETIME ,
	in p_school_nname VARCHAR(100) ,
	in p_degree_year INT  ,
	in p_degree_classification VARCHAR(20)
    )
begin
insert into degrees(
degree_name ,
emp_id ,
degree_date ,
school_nname ,
degree_year ,
degree_classification
) 
values(
p_degree_name ,
p_emp_id ,
p_degree_date ,
p_school_nname ,
p_degree_year ,
p_degree_classification
);
end $$
delimiter ;

#Procedure thực hiện lấy thông tin bằng cấp theo emp_id
delimiter $$
create procedure sp_get_degree_by_emp_id(in p_emp_id VARCHAR(15))
begin
select * from drgree
where emp_id  = p_emp_id;
end $$
delimiter ;

#Procedure thực hiện cập nhật thông tin bằng cấp
delimiter $$
create procedure sp_update_degree(
	in p_degree_id int,
    in p_degree_name VARCHAR(150),
	in p_emp_id VARCHAR(15) ,
	in p_degree_date DATETIME ,
	in p_school_nname VARCHAR(100) ,
	in p_degree_year INT  ,
	in p_degree_classification VARCHAR(20)
)
begin
update degrees
set
	degree_name = p_degree_name ,
	emp_id = p_emp_id ,
	degree_date = p_degree_date ,
	school_nname = p_school_nname ,
	egree_year = p_degree_year ,
	degree_classification = p_degree_classification
where degree_id = p_degree_id;
end $$
delimiter ;

#Procedure thực hiện xóa bằng cấp
delimiter $$
create procedure sp_delete_degree(in p_degree_id int)
begin
delete from drgree where degree_id = p_degree_id;
end $$
delimiter ;

#Procedure thực hiện tìm kiếm bằng cấp theo degree_name (Tìm gần đúng)
delimiter $$
create procedure sp_search_degree_by_name(in p_degree_name VARCHAR(150))
begin

select * from drgree
where degree_name like concat('%', p_degree_name,'%');
end $$
delimiter ;
 
select * from degrees;
insert into degrees(degree_name,emp_id,degree_date,school_nname,degree_year,degree_classification) values ( 'Ky Su Cau Duong', 'EP03', '2017-11-09', 'DHCT', 2022, 'Trung Binh');
insert into degrees(degree_name,emp_id,degree_date,school_nname,degree_year,degree_classification) values ('Ky Su Dien', 'EP02', '2016-10-09', 'DHCT', 2021, 'Kha');
insert into degrees(degree_name,emp_id,degree_date,school_nname,degree_year,degree_classification) values ('Ky Su Cau Duong', 'EP03', '2017-11-09', 'DHCT', 2022, 'Trung Binh');

