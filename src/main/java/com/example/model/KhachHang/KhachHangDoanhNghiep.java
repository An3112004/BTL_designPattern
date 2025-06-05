package com.example.model.KhachHang;

public class KhachHangDoanhNghiep implements KhachHang {
    private String maKH;
    private String tenKH;
    private String loaiKH;

    public KhachHangDoanhNghiep(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.loaiKH = "Doanh Nghiep";
    }

    public KhachHangDoanhNghiep() {}

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