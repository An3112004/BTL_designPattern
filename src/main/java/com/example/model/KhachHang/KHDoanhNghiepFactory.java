package com.example.model.KhachHang;

public class KHDoanhNghiepFactory implements KhachHangFactory {
    @Override
    public KhachHang taoKhachHang(String maKH, String tenKH) {
        return new KhachHangDoanhNghiep(maKH, tenKH);
    }
}
