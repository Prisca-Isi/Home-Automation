show databases;

create database SmartHomeDB;

use SmartHomeDB;

create table Home_user
(
  userId int primary key auto_increment ,
  userLogin varchar(50),
  userPassword varchar(50),
  userName  varchar(50),
  userEmail  varchar(50),
  userDoB   varchar(50),
  userPhone int(10),
  userDesignation  varchar(50)
     
);

alter table home_user add column userStatus int(5);

select * from Home_user;
desc Home_user;

create database Employee;

desc employee;

use Employee;
show tables;

create table Employee 
(
   id int primary key ,
   name varchar(50),
   phone varchar(50)
);

insert into Employee (id , name , phone) values (1001,"paul","8505931676");
insert into Employee (id , name , phone) values (1002,"Moupi","996543254");
insert into Employee (id , name , phone) values (1003,"Sonny","875434476");

select * from employee;

use project;

show tables;



create table employeeLogin 
(
  emp_id int primary key auto_increment ,
  username varchar(50),
  password varchar(50)
)
;

create table employeeDetail
(
  empid int primary key auto_increment ,
  empName varchar (50),
  email varchar(50),
  password varchar(50),
  age varchar(20),
  biographie varchar(500),
  jobRoles varchar (100),
  interest varchar (100),
  status varchar (10)
);

truncate table employeedetail;
select * from employeedetail;
desc employeedetail;
alter table employeedetail drop column empid;
alter table employeeDetail add column empid int primary key auto_increment ;
alter table employeedetail add column status varchar(10);
alter table employeedetail modify column email  emails varchar(50) unique ;

insert into employeeDetail values ("idriss","moupi@gmail.com","lebosse",">13","that is my biographie","programmer","developement");

select * from employeeDetail where email="mtisoft@gmail.com" and password ="lebosse";

select * from employeeDetail;

delete from employeedetail where empid=1;

select * from employeeLogin where username="emmanuel" and password="leboss";

insert into employeeLogin values (1,'emmanuel','leboss');

select * from employeeLogin; 

update employeedetail set password="123" , jobRoles ="development"  where empName="idriss";

drop table employeelogin;

alter table employee add column address varchar(30) after depart;

drop procedure getEmployee;

delimiter \\ 	
create procedure getEmployee (in empId int)
begin 
 select * from employee where id = empId;
 update employee set depart="finance" where id=3;
 select * from employee where id = empId+2;
 end; 
\\

call getEmployee(1);






