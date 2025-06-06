package com.example.adapter.adaptee;

import com.example.dao.ConnectionManager;
import com.example.model.SanPham.SanPham;
import com.example.model.SanPham.SanPhamFactory;
import com.example.model.SanPham.SanPhamFactoryProducer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    public List<SanPham> findAll() {
        List<SanPham> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM sanpham";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String ma = rs.getString("maSP");
                String ten = rs.getString("tenSP");
                String loai = rs.getString("loaiSP");
                double gia = rs.getDouble("gia");

                // Dùng Factory Method để tạo sản phẩm phù hợp
                SanPhamFactory factory = SanPhamFactoryProducer.getFactory(loai);
                SanPham sp = factory.taoSanPham(ma, ten, gia);
                danhSach.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSach;
    }

    public void insert(SanPham sp) {
        String sql = "INSERT INTO sanpham (maSP, tenSP, loaiSP, gia) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sp.getMaSP());
            stmt.setString(2, sp.getTenSP());
            stmt.setString(3, sp.getLoaiSP());
            stmt.setDouble(4, sp.getGia());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(SanPham sp) {
        String sql = "UPDATE sanpham SET tenSP = ?, loaiSP = ?, gia = ? WHERE maSP = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sp.getTenSP());
            stmt.setString(2, sp.getLoaiSP());
            stmt.setDouble(3, sp.getGia());
            stmt.setString(4, sp.getMaSP());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String maSP) {
        String sql = "DELETE FROM sanpham WHERE maSP = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maSP);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

