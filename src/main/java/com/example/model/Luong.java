package com.example.model;

public class Luong {
    private String maLuong;
    private String maNV;
    private double luongCoBan;
    private double phuCap;

    // Constructors
    public Luong() {}

    public Luong(String maLuong, String maNV, double luongCoBan, double phuCap) {
        this.maLuong = maLuong;
        this.maNV = maNV;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
}

