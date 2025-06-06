package com.example.adapter.adaptee;

import com.example.dao.ConnectionManager;
import com.example.model.NhanVien.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    public List<NhanVien> findAll() {
        List<NhanVien> list = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM nhanvien");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String manv = rs.getString("MaNV");
                String tennv = rs.getString("TenNV");
                String vaitro = rs.getString("VaiTro");
                NhanVien nv = new NhanVien(manv , tennv , vaitro);
                list.add(nv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(NhanVien nv) {
        String sql = "INSERT INTO nhanvien (MaNV, TenNV, VaiTro) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getVaiTro());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(NhanVien nv) {
        String sql = "UPDATE nhanvien SET TenNV = ?, VaiTro = ? WHERE MaNV = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getVaiTro());
            ps.setString(3, nv.getMaNV());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String maNV) {
        String sql = "DELETE FROM nhanvien WHERE MaNV = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNV);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
