package com.example.model.KhachHang;

public class ClientKhachHang {
    private KhachHangFactory factory;

    public ClientKhachHang(KhachHangFactory factory) {
        this.factory = factory;
    }

    public KhachHang taoKhachHang(String maKH, String tenKH) {
        return factory.taoKhachHang(maKH, tenKH);
    }
}
