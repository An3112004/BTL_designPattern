package com.example.model.NhaCungCap;

public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;

    public NhaCungCap(String maNCC, String tenNCC, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
    }

    public String getMaNCC() { return maNCC; }
    public String getTenNCC() { return tenNCC; }
    public String getDiaChi() { return diaChi; }

    public void setTenNCC(String tenNCC) { this.tenNCC = tenNCC; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
}

