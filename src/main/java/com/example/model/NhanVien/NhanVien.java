package com.example.model.NhanVien;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String vaiTro;

    public NhanVien(String maNV, String tenNV, String vaiTro) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.vaiTro = vaiTro;
    }

    public NhanVien() {}

    public void setMaNV(String maNV) { this.maNV = maNV; }
    public void setTenNV(String tenNV) { this.tenNV = tenNV; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }

    public String getMaNV() { return maNV; }
    public String getTenNV() { return tenNV; }
    public String getVaiTro() { return vaiTro; }
}
