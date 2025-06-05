package com.example.model.NhanVien;

public class NhanVienBanHangBuilder implements NhanVienBuilder {
    private NhanVien nhanVien;

    public NhanVienBanHangBuilder() {
        reset();
    }

    @Override
    public void reset() {
        nhanVien = new NhanVien();
    }

    @Override
    public void buildMaNV(String maNV) {
        nhanVien.setMaNV(maNV);
    }

    @Override
    public void buildTenNV(String tenNV) {
        nhanVien.setTenNV(tenNV);
    }

    @Override
    public void buildVaiTro() {
        nhanVien.setVaiTro("Nhân viên bán hàng");
    }

    @Override
    public NhanVien build(String ma, String tenNV) {
        reset();
        buildMaNV(ma);
        buildTenNV(tenNV);
        buildVaiTro(); // "Nhân viên bán hàng" là mặc định
        return nhanVien;
    }
}

