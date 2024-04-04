package model;

/**
 *
 * @author Surface
 */
public class SanPhamCT {

    Integer idSP, soLuong, idMauSac, idSize, idThuongHieu, idChatLieu, idLS, phanTramKM;
    String maSP, loaiSP, trangThai, tenMS, tenSize, tenTH, tenCL, tenSP, hinhAnh;
    Double giaNhap, giaBan;
    String maKM, ngayTao, ngayKetThuc, trangThaiKM, ngayQuyetDinh;

    public SanPhamCT() {
    }

    public SanPhamCT(Integer soLuong, Integer idMauSac, Integer idSize, Integer idThuongHieu, Integer idChatLieu, String maSP, String loaiSP, String trangThai, Double giaNhap, String hinhAnh) {
        this.soLuong = soLuong;
        this.idMauSac = idMauSac;
        this.idSize = idSize;
        this.idThuongHieu = idThuongHieu;
        this.idChatLieu = idChatLieu;
        this.maSP = maSP;
        this.loaiSP = loaiSP;
        this.trangThai = trangThai;
        this.giaNhap = giaNhap;
        this.hinhAnh = hinhAnh;
    }

    public SanPhamCT(Integer idSP, Integer soLuong, Integer idMauSac, Integer idSize, Integer idThuongHieu, Integer idChatLieu, Integer idLS, Integer phanTramKM, String maSP, String loaiSP, String trangThai, String tenMS, String tenSize, String tenTH, String tenCL, String tenSP, String hinhAnh, Double giaNhap, Double giaBan, String maKM, String ngayTao, String ngayKetThuc, String trangThaiKM, String ngayQuyetDinh) {
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.idMauSac = idMauSac;
        this.idSize = idSize;
        this.idThuongHieu = idThuongHieu;
        this.idChatLieu = idChatLieu;
        this.idLS = idLS;
        this.phanTramKM = phanTramKM;
        this.maSP = maSP;
        this.loaiSP = loaiSP;
        this.trangThai = trangThai;
        this.tenMS = tenMS;
        this.tenSize = tenSize;
        this.tenTH = tenTH;
        this.tenCL = tenCL;
        this.tenSP = tenSP;
        this.hinhAnh = hinhAnh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.maKM = maKM;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThaiKM = trangThaiKM;
        this.ngayQuyetDinh = ngayQuyetDinh;
    }

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public Integer getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(Integer idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public Integer getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(Integer idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public Integer getIdLS() {
        return idLS;
    }

    public void setIdLS(Integer idLS) {
        this.idLS = idLS;
    }

    public Integer getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(Integer phanTramKM) {
        this.phanTramKM = phanTramKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTrangThaiKM() {
        return trangThaiKM;
    }

    public void setTrangThaiKM(String trangThaiKM) {
        this.trangThaiKM = trangThaiKM;
    }

    public String getNgayQuyetDinh() {
        return ngayQuyetDinh;
    }

    public void setNgayQuyetDinh(String ngayQuyetDinh) {
        this.ngayQuyetDinh = ngayQuyetDinh;
    }

}
