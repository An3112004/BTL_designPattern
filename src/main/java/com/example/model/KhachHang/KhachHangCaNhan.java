package com.example.model.KhachHang;

public class KhachHangCaNhan implements KhachHang {
    private String maKH;
    private String tenKH;
    private String loaiKH;

    public KhachHangCaNhan(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.loaiKH = "Ca Nhan";
    }

    public KhachHangCaNhan() {}

    @Override
    public String getMaKH() {
        return maKH;
    }

    @Override
    public String getTenKH() {
        return tenKH;
    }

    @Override
    public String getLoaiKH() {
        return loaiKH;
    }
    
}
