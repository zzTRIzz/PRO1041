create database PRO1041;
go 
use PRO1041
go

create table NhanVien(
maNV varchar(20) primary key,
tenNV nvarchar(50) not null,
ngaySinh date,
gioiTinh nvarchar(20),
diaChi nvarchar(50),
sdt varchar(13),
taiKhoan varchar(20) not null,
matKhau varchar(20) not null
);
alter table NhanVien add vaiTro bit;
create table Voucher(
maVoucher varchar(20) primary key,
tenVoucher nvarchar(50) not null,
dkApDung money not null,
ghiChu nvarchar(50)
);
alter table Voucher add maNV varchar(20) references NhanVien(maNV);
create table KhachHang(
maKH varchar(20) primary key,
tenKH nvarchar(50) not null,
diaChi nvarchar(50),
namSinh varChar(10),
gioiTinh nvarchar(20),
sdt varchar(13) not null
);
create table ThuongHieu(
idThuongHieu int identity(1,1) primary key,
maThuongHieu varchar(20) not null unique,
tenThuongHieu nvarchar(50) not null,
ghiChu nvarchar(50) not null
);
create table ChatLieu(
idChatLieu int identity(1,1) primary key,
maChatLieu varchar(20) not null unique,
tenChatLieu nvarchar(50) not null,
ghiChu nvarchar(50) not null
);
create table Size(
idSize int identity(1,1) primary key,
maSize varchar(20) not null unique,
tenSize nvarchar(50) not null,
ghiChu nvarchar(50) not null
);
create table MauSac(
idMauSac int identity(1,1) primary key,
maMauSac varchar(20) not null unique,
tenMauSac nvarchar(50) not null,
ghiChu nvarchar(50) not null
);
create table SanPham(
maSP varchar(20) primary key,
tenSP nvarchar(50) not null,
ngayNhap date,
maNV varchar(20) references NhanVien(maNV)
);
create table KhuyenMai(
maKM varchar(20) primary key,
tenKM nvarchar(50) not null,
giamTheoGia int,
giamTheoPT int,
ngayTao date not null,
ngayKetThuc date not null,
trangThai nvarchar(50),
mucGiaApDung money
);
alter table KhuyenMai add maNV varchar(20) references NhanVien(maNV);
-- Nen cho voucher vao HoaDon hay HoaDonChiTiet ?
create table HoaDon(
maHD varchar(20) primary key,
ngayTao date,
tenNguoiTao nvarchar(50),
trangThai nvarchar(50),
maNV varchar(20) references NhanVien(maNV),
maKH varchar(20) references KhachHang(maKH),
maVoucher varchar(20) references Voucher(maVoucher)
);
create table SanPhamCT(
idSP int identity(1,1) primary key,
maSP varchar(20) references SanPham(maSP),
loaiSP nvarchar(50) not null,
soLuong int,
giaNhap money,
trangThai nvarchar(50),
idMauSac int references MauSac(idMauSac),
idSize int references Size(idSize),
idThuongHieu int references ThuongHieu(idThuongHieu),
idChatLieu int references ChatLieu(idChatLieu),
);
create table SanPhamKM(
idSPKM int identity(1,1) primary key,
maKM varchar(20) references KhuyenMai(maKM),
idSP int references SanPhamCT(idSP)
);
create table LichSuGia(
idLS int identity(1,1) primary key,
idSP int references SanPhamCT(idSP),
gia money,
ngayBatDau varchar(50),
ngayKetThuc varchar(50)
);
create table HoaDonChiTiet(
idHoaDonCT int identity(1,1) primary key,
idSP int references SanPhamCT(idSP),
maHD varchar(20) references HoaDon(maHD),
soLuongMua int not null,
tongTien money,
);

INSERT INTO NhanVien (maNV, tenNV, ngaySinh, gioiTinh, diaChi, sdt, taiKhoan, matKhau, vaiTro)
VALUES 
('NV001', N'Nguyễn Văn A', '1990-01-01', N'Nam', N'Hà Nội', '0123456789', 'nvA001', '123456', 1),
('NV002', N'Trần Thị B', '1995-05-05', N'Nữ', N'Hồ Chí Minh', '0987654321', 'nvB001', 'abcdef', 0),
('NV003', N'Lê Văn C', '1988-03-15', N'Nam', N'Đà Nẵng', '0367890123', 'lvC001', 'pass123', 1),
('NV004', N'Huỳnh Thị D', '1992-11-20', N'Nữ', N'Cần Thơ', '0987123456', 'htD001', 'pass456', 0),
('NV005', N'Phạm Văn E', '1985-07-10', N'Nam', N'Hải Phòng', '0918234567', 'pvE001', 'pass789', 1);

INSERT INTO Voucher (maVoucher, tenVoucher, dkApDung, ghiChu, maNV)
VALUES 
('VC001', N'Voucher 1', 50000, N'Áp dụng cho đơn hàng trên 1 triệu', 'NV001'),
('VC002', N'Voucher 2', 100000, N'Áp dụng cho khách hàng mới', 'NV002'),
('VC003', N'Voucher 3', 70000, N'Áp dụng cho đơn hàng từ 500.000 đồng trở lên', 'NV003'),
('VC004', N'Voucher 4', 80000, N'Áp dụng cho đơn hàng từ 800.000 đồng trở lên', 'NV004'),
('VC005', N'Voucher 5', 60000, N'Áp dụng cho mọi đơn hàng', 'NV005');

INSERT INTO KhachHang (maKH, tenKH, diaChi, namSinh, gioiTinh, sdt)
VALUES 
('KH001', N'Trần Văn C', N'Đà Nẵng', '1988-12-12', N'Nam', '0987123456'),
('KH002', N'Nguyễn Thị D', N'Hải Phòng', '1992-10-10', N'Nữ', '0918234567'),
('KH003', N'Lê Thị E', N'Hồ Chí Minh', '1995-01-25', N'Nữ', '0978123456'),
('KH004', N'Huỳnh Văn F', N'Cần Thơ', '1987-08-20', N'Nam', '0981234567'),
('KH005', N'Phạm Thị G', N'Hà Nội', '1990-05-15', N'Nữ', '0967123456');

INSERT INTO ThuongHieu (maThuongHieu, tenThuongHieu, ghiChu)
VALUES 
('TH001', N'Thuong Hieu 1', N'Ghi chú thương hiệu 1'),
('TH002', N'Thuong Hieu 2', N'Ghi chú thương hiệu 2'),
('TH003', N'Thuong Hieu 3', N'Ghi chú thương hiệu 3'),
('TH004', N'Thuong Hieu 4', N'Ghi chú thương hiệu 4'),
('TH005', N'Thuong Hieu 5', N'Ghi chú thương hiệu 5');

INSERT INTO ChatLieu (maChatLieu, tenChatLieu, ghiChu)
VALUES 
('CL001', N'Chất liệu 1', N'Ghi chú chất liệu 1'),
('CL002', N'Chất liệu 2', N'Ghi chú chất liệu 2'),
('CL003', N'Chất liệu 3', N'Ghi chú chất liệu 3'),
('CL004', N'Chất liệu 4', N'Ghi chú chất liệu 4'),
('CL005', N'Chất liệu 5', N'Ghi chú chất liệu 5');

INSERT INTO Size (maSize, tenSize, ghiChu)
VALUES 
('S001', N'Size 1', N'Ghi chú size 1'),
('S002', N'Size 2', N'Ghi chú size 2'),
('S003', N'Size 3', N'Ghi chú size 3'),
('S004', N'Size 4', N'Ghi chú size 4'),
('S005', N'Size 5', N'Ghi chú size 5');

INSERT INTO MauSac (maMauSac, tenMauSac, ghiChu)
VALUES 
('MS001', N'Màu sắc 1', N'Ghi chú màu sắc 1'),
('MS002', N'Màu sắc 2', N'Ghi chú màu sắc 2'),
('MS003', N'Màu sắc 3', N'Ghi chú màu sắc 3'),
('MS004', N'Màu sắc 4', N'Ghi chú màu sắc 4'),
('MS005', N'Màu sắc 5', N'Ghi chú màu sắc 5');

INSERT INTO SanPham (maSP, tenSP, ngayNhap, maNV)
VALUES 
('SP001', N'Sản phẩm 1', '2024-03-10', 'NV001'),
('SP002', N'Sản phẩm 2', '2024-03-11', 'NV002'),
('SP003', N'Sản phẩm 3', '2024-03-12', 'NV003'),
('SP004', N'Sản phẩm 4', '2024-03-13', 'NV004'),
('SP005', N'Sản phẩm 5', '2024-03-14', 'NV005');

INSERT INTO KhuyenMai (maKM, tenKM, giamTheoGia, giamTheoPT, ngayTao, ngayKetThuc, trangThai, mucGiaApDung, maNV)
VALUES 
('KM001', N'Khuyen Mai 1', 10000, NULL, '2024-03-10', '2024-03-20', N'Hoạt động', 50000, 'NV001'),
('KM002', N'Khuyen Mai 2', NULL, 10, '2024-03-11', '2024-03-25', N'Hoạt động', 0, 'NV002'),
('KM003', N'Khuyen Mai 3', 15000, NULL, '2024-03-12', '2024-03-22', N'Hoạt động', 70000, 'NV003'),
('KM004', N'Khuyen Mai 4', NULL, 12, '2024-03-13', '2024-03-27', N'Hoạt động', 0, 'NV004'),
('KM005', N'Khuyen Mai 5', 20000, NULL, '2024-03-14', '2024-03-24', N'Hoạt động', 80000, 'NV005');

INSERT INTO HoaDon (maHD, ngayTao, tenNguoiTao, trangThai, maNV, maKH, maVoucher)
VALUES 
('HD001', '2024-03-10', N'Nguyễn Văn A', N'Chờ xác nhận', 'NV001', 'KH001', 'VC001'),
('HD002', '2024-03-11', N'Trần Thị B', N'Đã thanh toán', 'NV002', 'KH002', 'VC002'),
('HD003', '2024-03-12', N'Lê Văn C', N'Chờ thanh toán', 'NV003', 'KH003', 'VC003'),
('HD004', '2024-03-13', N'Huỳnh Thị D', N'Chờ xác nhận', 'NV004', 'KH004', 'VC004'),
('HD005', '2024-03-14', N'Phạm Văn E', N'Đã hoàn thành', 'NV005', 'KH005', 'VC005');

INSERT INTO SanPhamCT (maSP, loaiSP, soLuong, giaNhap, trangThai, idMauSac, idSize, idThuongHieu, idChatLieu)
VALUES 
('SP001', N'Loại 1', 50, 50000, N'Còn hàng', 1, 1, 1, 1),
('SP002', N'Loại 2', 30, 70000, N'Còn hàng', 2, 2, 2, 2),
('SP003', N'Loại 3', 40, 80000, N'Còn hàng', 3, 3, 3, 3),
('SP004', N'Loại 4', 20, 90000, N'Hết hàng', 4, 4, 4, 4),
('SP005', N'Loại 5', 60, 100000, N'Còn hàng', 5, 5, 5, 5);

INSERT INTO SanPhamKM (maKM, idSP)
VALUES 
('KM001', 1),
('KM002', 2),
('KM003', 3),
('KM004', 4),
('KM005', 5);


INSERT INTO LichSuGia (idSP, gia, ngayBatDau, ngayKetThuc)
VALUES 
(1, 55000, '2024-03-10', 'null'),
(2, 75000, '2024-03-11', 'null'),
(3, 95000, '2024-03-12', 'null'),
(4, 125000, '2024-03-13', 'null'),
(5, 155000, '2024-03-14', 'null');

INSERT INTO HoaDonChiTiet (idSP, maHD, soLuongMua, tongTien)
VALUES 
(1, 'HD001', 2, NULL),
(2, 'HD002', 3, NULL),
(3, 'HD003', 1, NULL),
(4, 'HD004', 2, NULL),
(5, 'HD005', 4, NULL);
