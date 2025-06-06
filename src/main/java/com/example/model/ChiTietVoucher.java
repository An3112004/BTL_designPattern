package com.example.model;

public class ChiTietVoucher {
    private String maCTVC;
    private String maVC;
    private String maKH;
    private String chiTietNoiDung;

    public ChiTietVoucher() {}

    public ChiTietVoucher(String maCTVC, String maVC, String maKH, String chiTietNoiDung) {
        this.maCTVC = maCTVC;
        this.maVC = maVC;
        this.maKH = maKH;
        this.chiTietNoiDung = chiTietNoiDung;
    }

    public String getMaCTVC() {
        return maCTVC;
    }

    public void setMaCTVC(String maCTVC) {
        this.maCTVC = maCTVC;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getChiTietNoiDung() {
        return chiTietNoiDung;
    }

    public void setChiTietNoiDung(String chiTietNoiDung) {
        this.chiTietNoiDung = chiTietNoiDung;
    }
}

