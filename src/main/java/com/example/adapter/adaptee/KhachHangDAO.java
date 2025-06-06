package com.example.adapter.adaptee;

import com.example.dao.ConnectionManager;
import com.example.model.KhachHang.KhachHang;
import com.example.model.KhachHang.KhachHangFactory;
import com.example.model.KhachHang.KhachHangFactoryProducer;
import com.example.model.NhanVien.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    public List<KhachHang> findAll() {
        List<KhachHang> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String ma = rs.getString("maKH");
                String ten = rs.getString("tenKH");
                String loai = rs.getString("loaiKH");

                KhachHangFactory factory = KhachHangFactoryProducer.getFactory(loai);
                KhachHang kh = factory.taoKhachHang(ma, ten);
                danhSach.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSach;
    }

    public void insert(KhachHang kh) {
        String sql = "INSERT INTO KhachHang (maKH, tenKH, loaiKH) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, kh.getMaKH());
            stmt.setString(2, kh.getTenKH());
            stmt.setString(3, kh.getLoaiKH());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(KhachHang kh) {
        String sql = "UPDATE KhachHang SET tenKH = ?, loaiKH = ? WHERE maKH = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, kh.getTenKH());
            stmt.setString(2, kh.getLoaiKH());
            stmt.setString(3, kh.getMaKH());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String maKH) {
        String sql = "DELETE FROM KhachHang WHERE maKH = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maKH);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

