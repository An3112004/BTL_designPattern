package com.example.model.SanPham;

public abstract class SanPham {
    protected String maSP;
    protected String tenSP;
    protected String loaiSP;
    protected double gia;

    public SanPham(String maSP, String tenSP, String loaiSP, double gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.gia = gia;
    }

    public String getMaSP() { return maSP; }
    public String getTenSP() { return tenSP; }
    public String getLoaiSP() { return loaiSP; }
    public double getGia() { return gia; }
}
