package com.example.model;

import java.util.Date;

public class DatHang {
    private String maDH;
    private Date ngayDat;
    private int trangThai;
    private double tongTien;
    private String hinhThucThanhToan;
    private String maKH;

    public DatHang() {}

    public DatHang(String maDH, Date ngayDat, int trangThai, double tongTien, String hinhThucThanhToan, String maKH) {
        this.maDH = maDH;
        this.ngayDat = ngayDat;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.maKH = maKH;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
}

