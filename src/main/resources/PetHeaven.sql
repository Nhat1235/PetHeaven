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
parentname nvarchar(200) not null,
categoryname nvarchar(200) not null,
)

create table Product(
ProductID int identity(1,1) primary key,
NAME nvarchar(500) null,
DETAIL ntext null,
PRICE varchar(200) null,
IMAGE nvarchar(max) null,
IMAGE1 nvarchar(max) null,
IMAGE2 nvarchar(max) null,
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

insert into Category values (N'Phụ kiện',N'Chuồng,nhà cho chó')
insert into Category values (N'Phụ kiện',N'Chuồng,nhà cho mèo')
insert into Category values (N'Phụ kiện',N'Bát ăn')
insert into Category values (N'Thức ăn',N'Thức ăn mèo')
insert into Category values (N'Thức ăn',N'Thức ăn chó')
insert into Category values (N'Phụ kiện',N'Dây')
insert into Category values (N'Phụ kiện',N'Balo, túi đựng thú')
insert into Category values (N'Phụ kiện',N'Hộp vệ sinh')


insert into Product values (N'Petstar - Balo di chuyển phi hành gia (nhựa trong)',N'Màu: Vàng','200,000','https://www.petcity.vn/media/product/3757_balo_trong_vang.jpg','','','11-11-2020',1,7)

insert into Product values (N'Nhà lều Angry birds',N'Màu: Đỏ','200,000','https://www.petcity.vn/media/product/386_1_386_dem_angry_birds.jpg','','','11-11-2020',1,1)

insert into Product values (N'Túi xách vận chuyển thú cưng vòm lưới nhỏ',N'Khối lượng: 400g, 1Kg','200,000','https://www.petcity.vn/media/product/2402_tui_van_chuyen_luoi_thoang_khi_cho_cho_meo_3_2ea8963b_a1bc_4393_967a_4b771586e620.jpg','','','11-11-2020',1,7)

insert into Product values (N'Hạt MeO cho mèo các loại',N'Màu: Xanh','200,000','https://product.hstatic.net/1000104513/product/05279fd197c24be8a92a21eb66617c50_846a7826db48449d8beb78e7fb7a99b6.jpg','','','11-11-2020',1,4)

insert into Product values (N'Khay vệ sinh cho mèo IRIS NE-550',N'Thương hiệu: OEM','200,000','https://product.hstatic.net/1000104513/product/beaf5a2b51cb44339b2b1bfc94401722_43fd4d1f745041d4b3bd14e54dace156.jpg','','','11-11-2020',1,8)

insert into Product values (N'Hạt Nutri Source PureVita cho mèo 3kg',N'Thương hiệu: Nutri Source, Vị: Cá, gà','200,000','https://product.hstatic.net/1000104513/product/u26znq_simg_de2fe0_500x500_maxb_eb5634d8858140bfb3d0f78018e1c233.png','','','11-11-2020',1,4)

insert into Product values (N'Hạt Pedigree chó con vị gà, trứng và sữa',N'Thương hiệu: Pedigree, Khối lượng: 400g','200,000','https://product.hstatic.net/1000104513/product/37300d52605046d9a406ad7c0246085a_5411482ec59d49449247f5fe35717301.jpeg','','','11-11-2020',1,5)

insert into Product values (N'Hạt ANF 6 Free Dog cho chó 2kg',N'Vị: Cá hồi, cừu, vịt','200,000','https://product.hstatic.net/1000104513/product/b5986a1e156845be968b13e6c4b7dc83_aaf42d79b09c46a584ecdc544c400eaf.jpg','','','11-11-2020',1,5)

insert into Product values (N'Hạt Ganador Premium cho chó 400g',N'Thương hiệu: ADM','200,000','https://product.hstatic.net/1000104513/product/packagin-515-341-08-199x300_2a00c148aacf4434a5a0856784477185.png','','','11-11-2020',1,5)

insert into Product values (N'Ferplast Maxi Bella Cabrio - Nhà vệ sinh cho mèo lớn và chó nhỏ',N'Thương hiệu: Ferplast','200,000','https://product.hstatic.net/1000104513/product/8b1fa2b18c3811e4872360d819ddcce3-bc04a3e0841411e780cc704d7b6583c9_3e88fa48b7444f21990fd07b2ffb7aac.jpg','','','11-11-2020',1,8)

insert into Product values (N'Xẻng dọn phân mèo',N'Thương hiệu: OEM','27,000','https://product.hstatic.net/1000104513/product/49e09c85ef2c9a636d90dca9ac751aa3_44a09d66d9874996abf609bb8b231cf9.jpg','','','11-11-2020',1,9)

insert into Product values (N'Lưới vỉ ghép chuồng kim loại và nút ghép cao su',N'Thương hiệu: OEM','200,000','https://product.hstatic.net/1000104513/product/43205b23649a4d52a950c882abbaf255_0d446ce0625f40a1bb6107898b18db15.jpg','','','11-11-2020',1,1)

insert into Product values (N'Pate Nekko cho mèo con gói 70g',N'Thương hiệu: Nekko, Loại sản phẩm: Pate Mèo','18,000','https://product.hstatic.net/1000104513/product/5437195c62699277fe1098f9dd1ccf72.jpg_720x720q80.jpg__7622925174e9411c85b5894673149792.jpg','https://product.hstatic.net/1000104513/product/5vmrsy_simg_de2fe0_500x500_maxb_e175a2321ab94c14ae34cd594b10b491.jpg','https://product.hstatic.net/1000104513/product/accf451172d64f41865203518e901242_c6aa5d8a37aa49139aa95818e4dc30b5.jpg','11-11-2020',1,4)

insert into Product values (N'Hạt Cats Eye cho mèo mọi độ tuổi',N'Thương hiệu: Hàn Quốc, Loại sản phẩm: Hạt Mèo','60,000','https://product.hstatic.net/1000104513/product/9f71b5c3a3134efaa5e11ff16a631994_2cf6d3db83434087ad6f9531611f110a.jpg','','','11-11-2020',1,4)


select * from ACCOUNT
select * from Customer
select * from Category
select * from Product

update account set role = 'ROLE_ADMIN'

SELECT COUNT(Username) AS NumberOfUsername FROM Account where USERNAME like 'nhat1231'

select distinct * from category where parentname like N'Thức ăn'
