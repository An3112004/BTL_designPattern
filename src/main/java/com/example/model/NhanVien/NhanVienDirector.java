package com.example.model.NhanVien;

public class NhanVienDirector {
    NhanVienBuilder nhanVienBuilder;

    public NhanVienDirector(NhanVienBuilder nhanVienBuilder) {
        this.nhanVienBuilder = nhanVienBuilder;
    }

    public void changeBuilder(NhanVienBuilder nhanVienBuilder) {
        this.nhanVienBuilder = nhanVienBuilder;
    }

    public void make(String maNV, String tenNV, String loaiKH) {

        if(loaiKH.equals("NhanVienKho")) {
            nhanVienBuilder.reset();
            nhanVienBuilder = new NhanVienKhoBuilder();
            nhanVienBuilder.buildMaNV(maNV);
            nhanVienBuilder.buildTenNV(tenNV);
            nhanVienBuilder.buildVaiTro();
        }
        if(loaiKH.equals("NhanVienBanHang")) {
            nhanVienBuilder.reset();
            nhanVienBuilder = new NhanVienBanHangBuilder();
            nhanVienBuilder.buildMaNV(maNV);
            nhanVienBuilder.buildTenNV(tenNV);
            nhanVienBuilder.buildVaiTro();
        }
    }
}

