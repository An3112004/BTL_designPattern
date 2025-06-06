package com.example.model;

import java.util.Date;

public class HoaDonBan {
    private String maHDB;
    private String maKH;
    private String maVC;
    private String maDH;
    private double tongTien;
    private Date ngayDatHang;
    private int trangThai;

    public HoaDonBan() {}

    public HoaDonBan(String maHDB, String maKH, String maVC, String maDH, double tongTien, Date ngayDatHang, int trangThai) {
        this.maHDB = maHDB;
        this.maKH = maKH;
        this.maVC = maVC;
        this.maDH = maDH;
        this.tongTien = tongTien;
        this.ngayDatHang = ngayDatHang;
        this.trangThai = trangThai;
    }

    public String getMaHDB() {
        return maHDB;
    }

    public void setMaHDB(String maHDB) {
        this.maHDB = maHDB;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}

