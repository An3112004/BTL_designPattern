package com.example.model.NhaCungCap;

public class NhaCungCapManager {
    private static NhaCungCapManager instance;

    private NhaCungCapManager() {}

    public static NhaCungCapManager getInstance() {
        if (instance == null) {
            instance = new NhaCungCapManager();
        }
        return instance;
    }

    public NhaCungCap taoNhaCungCap(String ma, String ten, String diaChi) {
        return new NhaCungCap(ma, ten, diaChi);
    }
}
