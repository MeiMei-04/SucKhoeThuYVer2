CREATE DATABASE DATABASETHUY;
use DATABASETHUY;
CREATE TABLE danhmucdongvat(
    id int IDENTITY(1,1) PRIMARY KEY not null,
    tendm NVARCHAR(50) not null,
)
CREATE Table danhsachdongvat(
    id int IDENTITY(1,1) PRIMARY KEY not null,
    id_danhmuc int not null,
    tendv nvarchar(50) not null,
    cannang float not null,
    anh varchar(255) not null,
    FOREIGN KEY (id_danhmuc)
    REFERENCES danhmucdongvat(id)
)
CREATE TABLE lichsutiemphong(
    id int IDENTITY(1,1) PRIMARY KEY not null,
    id_dv int not null,
	thuocdasudung NVARCHAR(255) not null,
    ngaytiem datetime not null,
	tinhtrangsaukhitiem NVARCHAR(255) not null
    FOREIGN KEY (id_dv)
    REFERENCES danhsachdongvat(id)
)
CREATE TABLE lichsukhambenh(
    id int IDENTITY(1,1) PRIMARY KEY not null,
    id_dv int not null,
    loaibenh NVARCHAR(50) not null,
    ngaykhambenh datetime not null,
	tinhtrangbenh NVARCHAR(255) not null,
    FOREIGN KEY (id_dv)
    REFERENCES danhsachdongvat(id)
)
INSERT INTO danhmucdongvat (tendm) VALUES
(N'Lợn'),
(N'Gà'),
(N'Bò'),
(N'Trâu');
INSERT INTO danhsachdongvat (id_danhmuc, tendv, cannang, anh) VALUES
(1, N'Lợn Móng Cái', 150.5, 'lon_mong_cai.jpg'),
(2, N'Gà Đông Tảo', 3.2, 'ga_dong_tao.jpg'),
(3, N'Bò Vàng', 400.0, 'bo_vang.jpg'),
(4, N'Trâu Đen', 500.0, 'trau_den.jpg');
INSERT INTO lichsutiemphong (id_dv, thuocdasudung, ngaytiem, tinhtrangsaukhitiem) VALUES
(1, N'Vacxin Tai Xanh', '2023-01-15', N'Khỏe mạnh'),
(2, N'Vacxin Cúm Gia Cầm', '2023-02-10', N'Không phản ứng'),
(3, N'Vacxin Lở Mồm Long Móng', '2023-03-05', N'Khỏe mạnh'),
(4, N'Vacxin Tụ Huyết Trùng', '2023-04-12', N'Sốt nhẹ');
INSERT INTO lichsukhambenh (id_dv, loaibenh, ngaykhambenh, tinhtrangbenh) VALUES
(1, N'Tai Xanh', '2023-01-10', N'Nặng'),
(2, N'Cúm Gia Cầm', '2023-02-05', N'Nhẹ'),
(3, N'Lở Mồm Long Móng', '2023-03-01', N'Trung bình'),
(4, N'Tụ Huyết Trùng', '2023-04-07', N'Nặng');
SELECT * FROM danhmucdongvat 
Select danhsachdongvat.id,danhsachdongvat.id_danhmuc,danhmucdongvat.tendm,danhsachdongvat.tendv,danhsachdongvat.cannang,danhsachdongvat.anh from danhsachdongvat
join danhmucdongvat
on danhsachdongvat.id_danhmuc = danhmucdongvat.id
Select danhsachdongvat.id,danhsachdongvat.id_danhmuc,danhmucdongvat.tendm,danhsachdongvat.tendv,danhsachdongvat.cannang,danhsachdongvat.anh from danhsachdongvat
join danhmucdongvat
on danhsachdongvat.id_danhmuc = danhmucdongvat.id where danhsachdongvat.tendv like '%Vàng%'
Select lichsutiemphong.id,lichsutiemphong.id_dv,danhsachdongvat.tendv,lichsutiemphong.thuocdasudung,lichsutiemphong.ngaytiem,lichsutiemphong.tinhtrangsaukhitiem,danhsachdongvat.anh from lichsutiemphong
join danhsachdongvat
on lichsutiemphong.id_dv = danhsachdongvat.id
join danhmucdongvat
on danhsachdongvat.id_danhmuc = danhmucdongvat.id where danhmucdongvat.tendm = N'Lợn'
Select lichsukhambenh.id,lichsukhambenh.id_dv,danhsachdongvat.tendv,lichsukhambenh.loaibenh,lichsukhambenh.ngaykhambenh,lichsukhambenh.tinhtrangbenh, danhsachdongvat.anh from lichsukhambenh
join danhsachdongvat
on lichsukhambenh.id_dv = danhsachdongvat.id
join danhmucdongvat
on danhsachdongvat.id_danhmuc = danhmucdongvat.id where danhmucdongvat.tendm = N'Lợn'
-- Stored procedure to get the medical history statistics by month
-- Stored procedure to get the medical history statistics by month
Go;
CREATE PROCEDURE ThongKeLichSuKhamBenhTheoThang
    @Month INT,
    @Year INT
AS
BEGIN
    SELECT 
        lkb.id,
        lkb.id_dv,
        dsv.tendv,
        lkb.loaibenh,
        lkb.ngaykhambenh,
        lkb.tinhtrangbenh,
        dsv.anh 
    FROM 
        lichsukhambenh lkb
    JOIN 
        danhsachdongvat dsv ON lkb.id_dv = dsv.id
    JOIN 
        danhmucdongvat dmdv ON dsv.id_danhmuc = dmdv.id
    WHERE 
        MONTH(lkb.ngaykhambenh) = @Month AND YEAR(lkb.ngaykhambenh) = @Year
    ORDER BY 
        lkb.ngaykhambenh;
END;
GO

-- Stored procedure to get the vaccination history statistics by month
CREATE PROCEDURE ThongKeLichSuTiemPhongTheoThang
    @Month INT,
    @Year INT
AS
BEGIN
    SELECT 
        lt.id,
        lt.id_dv,
        dsv.tendv,
        lt.thuocdasudung,
        lt.ngaytiem,
        lt.tinhtrangsaukhitiem,
        dsv.anh 
    FROM 
        lichsutiemphong lt
    JOIN 
        danhsachdongvat dsv ON lt.id_dv = dsv.id
    JOIN 
        danhmucdongvat dmdv ON dsv.id_danhmuc = dmdv.id
    WHERE 
        MONTH(lt.ngaytiem) = @Month AND YEAR(lt.ngaytiem) = @Year
    ORDER BY 
        lt.ngaytiem;
END;
GO

EXEC ThongKeLichSuKhamBenhTheoThang @Month = 1, @Year = 2023;
EXEC ThongKeLichSuTiemPhongTheoThang @Month = 1, @Year = 2023;