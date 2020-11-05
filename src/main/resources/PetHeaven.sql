use master
IF EXISTS (SELECT * FROM sysdatabases WHERE name = N'PetHeaven')
DROP DATABASE PetHeaven
GO

create database PetHeaven
go
use PetHeaven
go

create TABLE ACCOUNT(
ID int identity(1,1) primary key ,
USERNAME nvarchar(100) not null,
PASSWORD varchar(100) not null,
EMAIL varchar(50)null,
ROLE nvarchar(50) null,
)

create table Customer (
CustomerID int identity(1,1) primary key,
IMAGE varchar(255) null,
ADRESS nvarchar(2000) null, 
PHONE varchar(20) null,
)

create table Category(
CategoryID int identity(1,1) primary key,
CategoryParent nvarchar(200) not null,
CategoryChild nvarchar(200) null,
)

create table Product(
ProductID int identity(1,1) primary key,
NAME nvarchar(500) null,
DETAIL ntext null,
PRICE float null,
IMAGE nvarchar(max) null,
DATE date null,
STATUS bit null,
idCategory int null,
foreign key (idCategory) references Category(CategoryID) on delete set null on update cascade,

)
create table Orders(
OrdersID int identity(1,1) primary key,
CUSTOMER_ID int null,
foreign key (Customer_Id) references Customer(CustomerID) on delete set null on update cascade,
DATE date null,
STATUS bit,
)

create table OrderDetail(
OrderDetailID int identity (1,1) primary key,
ORDERID int null,
foreign key (OrderId) references Orders(OrdersID) on delete set null on update cascade, 
PRODUCTID int null,
foreign key (ProductId) references Product(ProductID) on delete set null on update cascade, 
QUANTITY int null,
)


---insert

insert into Customer values (null,N'Số nhà 41,ngõ Trại Găng, phường Thanh Nhàn, quận Hai Bà Trưng, Hà Nội','0926881894')

insert into Category values (N'Chó',N'Chó cảnh')
insert into Category values (N'Mèo',N'Mèo cảnh')
insert into Category values (N'Chim',N'Chim cảnh')
insert into Category values (N'Cá',N'Cá cảnh')
insert into Category values (N'Phụ kiện',N'Nhà')
insert into Category values (N'Phụ kiện',N'Chuồng')
insert into Category values (N'Phụ kiện',N'Bát')
insert into Category values (N'Phụ kiện',N'Thức ăn')

insert into Product values (N'Chó shiba',N'Màu: Vàng',10000.0,'https://azpet.com.vn/wp-content/uploads/2019/10/cho-inu-shiba.jpg','11-02-2020',1,1)


select * from ACCOUNT
select * from Customer
select * from Category
select * from Product

update account set role = 'ROLE_ADMIN'

SELECT COUNT(Username) AS NumberOfUsername FROM Account where USERNAME like 'nhat1231'