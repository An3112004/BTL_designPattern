package com.example.model.SanPham;

public class DoDienTuFactory implements SanPhamFactory {
    @Override
    public SanPham taoSanPham(String maSP, String tenSP, double gia) {
        return new DoDienTu(maSP, tenSP, gia);
    }
}
