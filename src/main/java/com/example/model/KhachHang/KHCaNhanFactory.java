package com.example.model.KhachHang;

public class KHCaNhanFactory implements KhachHangFactory {
    @Override
    public KhachHang taoKhachHang(String maKH, String tenKH) {
        return new KhachHangCaNhan(maKH, tenKH);
    }
}