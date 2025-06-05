package com.example.model.SanPham;

public class SanPhamFactoryProducer {
    public static SanPhamFactory getFactory(String loai) {
        switch (loai.toLowerCase()) {
            case "đồ điện tử":
                return new DoDienTuFactory();
            case "quần áo":
                return new QuanAoFactory();
            default:
                throw new IllegalArgumentException("Loại sản phẩm không hợp lệ: " + loai);
        }
    }
}
