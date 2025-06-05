package com.example.model.KhachHang;

public class KhachHangFactoryProducer {
    public static KhachHangFactory getFactory(String vaiTro) {
        if ("Khách hàng cá nhân".equalsIgnoreCase(vaiTro) || "Ca Nhan".equalsIgnoreCase(vaiTro)) {
            return new KHCaNhanFactory();
        }
        else if ("Khách hàng doanh nghiệp".equalsIgnoreCase(vaiTro) || "Doanh Nghiep".equalsIgnoreCase(vaiTro)) {
            return new KHDoanhNghiepFactory();
        }
        throw new IllegalArgumentException("Vai trò không hợp lệ: " + vaiTro);
    }
}
