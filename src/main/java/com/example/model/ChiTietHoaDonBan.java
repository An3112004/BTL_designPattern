package com.example.model;

public class ChiTietHoaDonBan {
    private String maCTHDB;
    private String maHDB;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;

    public ChiTietHoaDonBan() {}

    public ChiTietHoaDonBan(String maCTHDB, String maHDB, String maSP, String tenSP, int soLuong, double donGia) {
        this.maCTHDB = maCTHDB;
        this.maHDB = maHDB;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaCTHDB() {
        return maCTHDB;
    }

    public void setMaCTHDB(String maCTHDB) {
        this.maCTHDB = maCTHDB;
    }

    public String getMaHDB() {
        return maHDB;
    }

    public void setMaHDB(String maHDB) {
        this.maHDB = maHDB;
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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
