package com.example.model;

public class GioHang {
    private String maGH;
    private String maKH;

    public GioHang() {}

    public GioHang(String maGH, String maKH) {
        this.maGH = maGH;
        this.maKH = maKH;
    }

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
}

