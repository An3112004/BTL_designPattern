package com.example.model;

import java.util.Date;

public class Voucher {
    private String maVC;
    private String noiDung;
    private int soLuongVC;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public Voucher() {}

    public Voucher(String maVC, String noiDung, int soLuongVC, Date ngayBatDau, Date ngayKetThuc) {
        this.maVC = maVC;
        this.noiDung = noiDung;
        this.soLuongVC = soLuongVC;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getSoLuongVC() {
        return soLuongVC;
    }

    public void setSoLuongVC(int soLuongVC) {
        this.soLuongVC = soLuongVC;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}

