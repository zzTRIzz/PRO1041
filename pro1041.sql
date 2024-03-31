create drop database PRO1041;
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
alter table NhanVien add email nvarchar(30);
create table Voucher(
maVoucher varchar(20) primary key,
tenVoucher nvarchar(50) not null,
dkApDung money not null,
giamTheoGia money not null,
ghiChu nvarchar(50)
);
alter table Voucher add maNV varchar(20) references NhanVien(maNV);
create table KhachHang(
idKH int identity(1,1) primary key,
maKH AS RIGHT('1111111' + CAST(idKH AS int), 7) PERSISTED,
tenKH nvarchar(50) not null,
diaChi nvarchar(50),
namSinh varChar(10),
gioiTinh nvarchar(20),
sdt varchar(13) not null
);
create table ThuongHieu(
idThuongHieu int identity(1,1) primary key,
maThuongHieu AS RIGHT('TH' + CAST(idThuongHieu AS varchar), 5) PERSISTED ,
tenThuongHieu nvarchar(50) not null,
ghiChu nvarchar(50) 
);
create table ChatLieu(
idChatLieu int identity(1,1) primary key,
maChatLieu AS RIGHT('CL' + CAST(idChatLieu AS varchar), 5) PERSISTED,
tenChatLieu nvarchar(50) not null,
ghiChu nvarchar(50) 
);
create table Size(
idSize int identity(1,1) primary key,
maSize AS RIGHT('SZ' + CAST(idSize AS varchar), 5) PERSISTED,
tenSize nvarchar(50) not null,
ghiChu nvarchar(50) 
);
create table MauSac(
idMauSac int identity(1,1) primary key,
maMauSac AS RIGHT('MS' + CAST(idMauSac AS varchar), 5) PERSISTED,
tenMauSac nvarchar(50) not null,
ghiChu nvarchar(50) 
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
CREATE TABLE HoaDon (
    idHD int IDENTITY(1,1) PRIMARY KEY,
    maHD AS RIGHT('1234567' + CAST(idHD AS int), 7) PERSISTED,
    ngayTao DATE,
    maNV VARCHAR(20) REFERENCES NhanVien(maNV),
    --maKH VARCHAR(20) REFERENCES KhachHang(maKH),
	idKH int REFERENCES KhachHang(idKH),
    maVoucher VARCHAR(20) REFERENCES Voucher(maVoucher),
    trangThai NVARCHAR(50)
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
idHD int references HoaDon(idHD),
soLuongMua int not null,
tongTien money,
);
delete from NhanVien;
delete from Voucher;
delete from KhachHang;
delete from ChatLieu;
delete from MauSac;
delete from ThuongHieu;
delete from Size;
delete from SanPham;
delete from KhuyenMai;
delete from HoaDon;
delete from SanPhamCT;
delete from SanPhamKM;
delete from LichSuGia;
delete from HoaDonChiTiet;

-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (maNV, tenNV, ngaySinh, gioiTinh , diaChi, sdt, taiKhoan, matKhau, vaiTro, email)
VALUES 
    ('NV001', N'Nguyễn Văn A', '1990-01-01', N'Nam', N'Hà Nội', '0123456789', 'tai_khoan_1', 'mat_khau_1', 1, 'nguyenvana@gmail.com'),
    ('NV002', N'Phạm Thị B', '1995-02-02', N'Nữ', N'Hồ Chí Minh', '0987654321', 'tai_khoan_2', 'mat_khau_2', 0, 'phamthib@gmail.com'),
    ('NV003', N'Trần Văn C', '1992-03-03', N'Nam', N'Hải Phòng', '0367891234', 'tai_khoan_3', 'mat_khau_3', 1, 'tranvanc@gmail.com'),
    ('NV004', N'Trần Thị G', '1994-07-07', N'Nữ', N'Hà Nội', '0987654321', 'tai_khoan_4', 'mat_khau_4', 1, 'tranthig@gmail.com'),
    ('NV005', N'Hoàng Văn H', '1991-08-08', N'Nam', N'Hồ Chí Minh', '0367891234', 'tai_khoan_5', 'mat_khau_5', 0, 'hoangvanh@gmail.com'),
    ('NV006', N'Nguyễn Thị I', '1996-09-09', N'Nữ', N'Hải Phòng', '0123456789', 'tai_khoan_6', 'mat_khau_6', 1, 'nguyenthii@gmail.com'),
    ('NV007', N'Đinh Văn K', '1993-10-10', N'Nam', N'Bắc Giang', '0367891234', 'tai_khoan_7', 'mat_khau_7', 0, 'dinhvank@gmail.com'),
    ('NV008', N'Lê Thị L', '1995-11-11', N'Nữ', N'Hải Dương', '0987654321', 'tai_khoan_8', 'mat_khau_8', 1, 'lethil@gmail.com');

	-- Thêm dữ liệu vào bảng Voucher
INSERT INTO Voucher (maVoucher, tenVoucher, dkApDung, ghiChu, maNV)
VALUES
    ('V001', N'Voucher giảm 50k', 50000, N'Áp dụng cho đơn hàng trên 300k', 'NV001'),
    ('V002', N'Voucher miễn phí vận chuyển', 0, N'Áp dụng cho đơn hàng trên 500k', 'NV002'),
    ('V003', N'Voucher giảm 20%', 0, N'Áp dụng cho đơn hàng trên 1 triệu', 'NV003'),
    ('V004', N'Voucher giảm 100k', 100000, N'Áp dụng cho đơn hàng trên 500k', 'NV007'),
    ('V005', N'Voucher giảm 30%', 0, N'Áp dụng cho đơn hàng trên 2 triệu', 'NV008');

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang ( tenKH, diaChi, namSinh, gioiTinh, sdt)
VALUES
    ( N'Lê Thị D', N'Đà Nẵng', '1993-04-04', N'Nữ', '0123456789'),
    ( N'Nguyễn Văn E', N'Bình Dương', '1988-05-05', N'Nam', '0987654321'),
    ( N'Trần Thị F', N'Cần Thơ', '1997-06-06', N'Nữ', '0367891234'),
    ( N'Nguyễn Văn M', N'Quảng Ninh', '1992-12-12', N'Nam', '0123456789'),
    ( N'Hoàng Thị N', N'Hải Phòng', '1989-01-01', N'Nữ', '0987654321'),
    ( N'Vũ Văn O', N'Thái Bình', '1998-02-02', N'Nam', '0367891234'),
    ( N'Đỗ Thị P', N'Hà Nam', '1990-03-03', N'Nữ', '0123456789'),
    ( N'Trần Văn Q', N'Nam Định', '1994-04-04', N'Nam', '0987654321');

-- Thêm dữ liệu vào bảng ThuongHieu
INSERT INTO ThuongHieu ( tenThuongHieu, ghiChu)
VALUES 
    ( N'Adidas', N'Nhãn hiệu thể thao'),
    ( N'Nike', N'Nhãn hiệu thể thao'),
    ( N'Gucci', N'Nhãn hiệu thời trang'),
    ( N'Puma', N'Nhãn hiệu thể thao'),
    ( N'New Balance', N'Nhãn hiệu thể thao'),
    ( N'Zara', N'Nhãn hiệu thời trang'),
    ( N'Uniqlo', N'Nhãn hiệu thời trang'),
    ( N'Converse', N'Nhãn hiệu thời trang');

-- Thêm dữ liệu vào bảng ChatLieu
INSERT INTO ChatLieu ( tenChatLieu, ghiChu)
VALUES 
    ( N'Cotton', N'Chất liệu vải'),
    ( N'Polyester', N'Chất liệu vải'),
    ( N'Denim', N'Chất liệu vải'),
    ( N'Lụa', N'Chất liệu vải'),
    ( N'Len', N'Chất liệu vải'),
    ( N'Satin', N'Chất liệu vải'),
    ( N'Thun lạnh', N'Chất liệu vải'),
    ( N'Cashmere', N'Chất liệu vải');

-- Thêm dữ liệu vào bảng Size
INSERT INTO Size ( tenSize, ghiChu)
VALUES 
    ( N'S', N'Size S'),
    ( N'M', N'Size M'),
    ( N'L', N'Size L'),
    ( N'XL', N'Size XL'),
    ( N'XXL', N'Size XXL'),
    ( N'XS', N'Size XS'),
    ( N'XXXL', N'Size XXXL'),
    ( N'XXS', N'Size XXS');

-- Thêm dữ liệu vào bảng MauSac
INSERT INTO MauSac ( tenMauSac, ghiChu)
VALUES 
    ( N'Trắng', N'Màu trắng'),
    ( N'Den', N'Màu đen'),
    ( N'Xanh', N'Màu xanh'),
    ( N'Hồng', N'Màu hồng'),
    ( N'Cam', N'Màu cam'),
    ( N'Vàng', N'Màu vàng'),
    ( N'Hồng đậm', N'Màu hồng đậm'),
    ( N'Xám', N'Màu xám');

-- Thêm dữ liệu vào bảng SanPham
INSERT INTO SanPham (maSP, tenSP, ngayNhap, maNV)
VALUES
	('SP001', N'Áo thun nam', '2024-03-18', 'NV001'),
    ('SP002', N'Áo khoác nữ', '2024-03-18', 'NV002'),
    ('SP003', N'Quần jeans nam', '2024-03-18', 'NV003'),
    ('SP004', N'Áo sơ mi nam', '2024-03-18', 'NV004'),
    ('SP005', N'Váy đầm nữ', '2024-03-18', 'NV005'),
    ('SP006', N'Quần tây nam', '2024-03-18', 'NV006'),
    ('SP007', N'Chân váy nữ', '2024-03-18', 'NV007'),
    ('SP008', N'Áo khoác nam', '2024-03-18', 'NV008');

-- Thêm dữ liệu vào bảng KhuyenMai
INSERT INTO KhuyenMai (maKM, tenKM, giamTheoGia, giamTheoPT, ngayTao, ngayKetThuc, trangThai, mucGiaApDung, maNV)
VALUES 
    ('KM001', N'Giảm giá mùa hè', 100000, NULL, '2024-03-18', '2024-03-31', N'Đang áp dụng', 0, 'NV001'),
    ('KM002', N'Khuyến mãi hóa đơn', NULL, 10, '2024-03-18', '2024-03-31', N'Đang áp dụng', 0, 'NV002'),
    ('KM003', N'Giảm giá Black Friday', 200000, NULL, '2024-11-25', '2024-11-30', N'Đang áp dụng', 0, 'NV003'),
    ('KM004', N'Khuyến mãi mùa đông', 150000, NULL, '2024-12-01', '2024-12-31', N'Đang áp dụng', 0, 'NV004'),
    ('KM005', N'Giảm giá sinh nhật', NULL, 15, '2024-03-01', '2024-03-31', N'Đang áp dụng', 0, 'NV005'),
    ('KM006', N'Quà tặng hấp dẫn', NULL, NULL, '2024-03-01', '2024-03-31', N'Đang áp dụng', 0, 'NV006');



		-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (ngayTao, maNV, idKH, maVoucher, trangThai)
VALUES 
    ('2024-03-18', 'NV001', 1, 'V001', N'Chưa thanh toán'),
    ('2024-03-18', 'NV001', 2, 'V002', N'Chưa thanh toán'),
    ('2024-03-18', 'NV001', 3, 'V003', N'Chưa thanh toán'),
    ('2024-03-19', 'NV001', 4, NULL, N'Chưa thanh toán'),
    ('2024-03-20', 'NV005', 5, 'V004', N'Đã thanh toán'),
    ('2024-03-21', 'NV006', 6, NULL, N'Đã thanh toán'),
    ('2024-03-22', 'NV007', 7, NULL, N'Đã thanh toán'),
    ('2024-03-23', 'NV008', 8, 'V005', N'Đã thanh toán');

	-- Thêm dữ liệu vào bảng SanPhamCT
INSERT INTO SanPhamCT (maSP, loaiSP, soLuong, giaNhap, trangThai, idMauSac, idSize, idThuongHieu, idChatLieu)
VALUES 
    ('SP001', N'Áo thun', 100, 50000, N'Không hoạt động', 1, 1, 1, 1),
    ('SP002', N'Áo khoác', 50, 100000, N'Hoạt động', 2, 2, 2, 2),
    ('SP003', N'Quần jeans', 80, 150000, N'Không hoạt động', 3, 3, 3, 3),
    ('SP004', N'Áo sơ mi', 50, 80000, N'Hoạt động', 4, 4, 4, 4),
    ('SP005', N'Váy đầm', 30, 120000, N'Không hoạt động', 5, 5, 5, 5),
    ('SP006', N'Quần tây', 40, 150000, N'Hoạt động', 6, 6, 6, 6),
    ('SP007', N'Chân váy', 35, 100000, N'Không hoạt động', 7, 7, 7, 7),
    ('SP008', N'Áo khoác', 45, 200000, N'Hoạt động', 8, 8, 8, 8);
	INSERT INTO SanPhamCT (maSP, loaiSP, soLuong, giaNhap, trangThai, idMauSac, idSize, idThuongHieu, idChatLieu)
VALUES 
    ('SP001', N'Áo thun', 100, 50000, N'Hoạt động', 1, 3, 1, 1);
	select* from SanPhamCT
-- Thêm dữ liệu vào bảng SanPhamKM
INSERT INTO SanPhamKM (maKM, idSP)
VALUES
	('KM001', 1),
    ('KM002', 2),
    ('KM003', 3),
    ('KM004', 4),
    ('KM005', 5),
    ('KM006', 6),
    ('KM004', 7),
    ('KM005', 8);

-- Thêm dữ liệu vào bảng LichSuGia
INSERT INTO LichSuGia (idSP, gia, ngayBatDau, ngayKetThuc)
VALUES 
	(1, 55000, '2024-03-18', '2024-03-31'),
    (2, 105000, '2024-03-18', '2024-03-31'),
    (3, 160000, '2024-03-18', '2024-03-31'),
    (4, 85000, '2024-03-18', '2024-03-31'),
    (5, 135000, '2024-03-18', '2024-03-31'),
    (6, 180000, '2024-03-18', '2024-03-31'),
    (7, 120000, '2024-03-18', '2024-03-31'),
    (8, 190000, '2024-03-18', '2024-03-31');

-- Thêm dữ liệu vào bảng HoaDonChiTiet
INSERT INTO HoaDonChiTiet (idSP, idHD, soLuongMua, tongTien)
VALUES 
    (1, 1, 2, 110000),
    (2, 1, 1, 105000),
    (3, 2, 3, 480000),
    (4, 3, 2, 170000),
    (5, 4, 1, 135000),
    (6, 5, 3, 360000),
    (7, 6, 2, 240000),
    (8, 7, 4, 760000);
	SELECT HoaDon.idHD, HoaDon.maHD, HoaDon.ngayTao, NhanVien.tenNV, KhachHang.tenKH, HoaDon.trangThai
FROM   HoaDon INNER JOIN
             KhachHang ON HoaDon.idKH = KhachHang.idKH INNER JOIN
             NhanVien ON HoaDon.maNV = NhanVien.maNV
where HoaDon.trangThai =N'Chưa thanh toán'

SELECT HoaDonChiTiet.idHoaDonCT, SanPham.tenSP, HoaDonChiTiet.soLuongMua, LichSuGia.gia, KhuyenMai.giamTheoGia, KhuyenMai.giamTheoPT
FROM   HoaDon INNER JOIN
             HoaDonChiTiet ON HoaDon.idHD = HoaDonChiTiet.idHD INNER JOIN
             SanPhamCT ON HoaDonChiTiet.idSP = SanPhamCT.idSP INNER JOIN
             LichSuGia ON SanPhamCT.idSP = LichSuGia.idSP INNER JOIN
             SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN
             SanPhamKM ON SanPhamCT.idSP = SanPhamKM.idSP INNER JOIN
             KhuyenMai ON SanPhamKM.maKM = KhuyenMai.maKM
where HoaDon.idHD ='';
select * from MauSac
SELECT KhuyenMai.maKM, KhuyenMai.tenKM, KhuyenMai.ngayTao, KhuyenMai.ngayKetThuc, SanPhamCT.loaiSP, KhuyenMai.giamTheoPT, KhuyenMai.trangThai
FROM   KhuyenMai INNER JOIN
             SanPhamKM ON KhuyenMai.maKM = SanPhamKM.maKM INNER JOIN
             SanPhamCT ON SanPhamKM.idSP = SanPhamCT.idSP
			 insert into KhuyenMai(KhuyenMai.maKM,KhuyenMai.tenKM,KhuyenMai.ngayTao,KhuyenMai.ngayKetThuc,SanPhamCT.loaiSP,KhuyenMai.giamTheoPT,KhuyenMai.trangThai) values ()

SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPham.tenSP, Size.tenSize, MauSac.tenMauSac, ChatLieu.tenChatLieu, SanPhamCT.giaNhap
FROM   ChatLieu INNER JOIN
             SanPhamCT ON ChatLieu.idChatLieu = SanPhamCT.idChatLieu INNER JOIN
             Size ON SanPhamCT.idSize = Size.idSize INNER JOIN
             MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN
             SanPham ON SanPhamCT.maSP = SanPham.maSP
			 SELECT SanPhamCT.idSP, SanPhamCT.maSP, SanPham.tenSP, Size.tenSize, MauSac.tenMauSac, ChatLieu.tenChatLieu, SanPhamCT.giaNhap
FROM   SanPhamCT INNER JOIN
             SanPham ON SanPhamCT.maSP = SanPham.maSP INNER JOIN
             Size ON SanPhamCT.idSize = Size.idSize INNER JOIN
             MauSac ON SanPhamCT.idMauSac = MauSac.idMauSac INNER JOIN
             ChatLieu ON SanPhamCT.idChatLieu = ChatLieu.idChatLieu
			 where SanPhamCT.giaNhap between ? and ?
			 select * from SanPhamKM
			 SELECT * FROM KhuyenMai

			 