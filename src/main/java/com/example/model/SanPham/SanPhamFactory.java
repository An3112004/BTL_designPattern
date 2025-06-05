package com.example.model.SanPham;

public interface SanPhamFactory {
    SanPham taoSanPham(String maSP, String tenSP, double gia);
}
