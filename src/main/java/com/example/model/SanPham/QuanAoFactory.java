package com.example.model.SanPham;

public class QuanAoFactory implements SanPhamFactory {
    @Override
    public SanPham taoSanPham(String maSP, String tenSP, double gia) {
        return new QuanAo(maSP, tenSP, gia);
    }
}
