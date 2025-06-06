package com.example.model;

public class ChiTietGioHang {
    private String maCTGH;
    private String maGH;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double gia;

    public ChiTietGioHang() {}

    public ChiTietGioHang(String maCTGH, String maGH, String maSP, String tenSP, int soLuong, double gia) {
        this.maCTGH = maCTGH;
        this.maGH = maGH;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getMaCTGH() {
        return maCTGH;
    }

    public void setMaCTGH(String maCTGH) {
        this.maCTGH = maCTGH;
    }

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}

