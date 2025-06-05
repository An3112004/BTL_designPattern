package com.example.model.NhanVien;

public interface NhanVienBuilder {
    void reset();
    void buildMaNV(String maNV);
    void buildTenNV(String tenNV);
    void buildVaiTro();  // Tự set theo loại
    NhanVien build(String maNV, String tenNV);
}


