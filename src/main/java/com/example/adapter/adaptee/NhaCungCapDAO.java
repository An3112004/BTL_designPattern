package com.example.adapter.adaptee;

import com.example.dao.ConnectionManager;
import com.example.model.NhaCungCap.NhaCungCap;
import com.example.model.NhaCungCap.NhaCungCapManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {
    public List<NhaCungCap> findAll() {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM nhacungcap";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String ma = rs.getString("maNCC");
                String ten = rs.getString("tenNCC");
                String diaChi = rs.getString("diaChi");

                // Dùng Singleton Factory
                NhaCungCap ncc = NhaCungCapManager.getInstance().taoNhaCungCap(ma, ten, diaChi);
                list.add(ncc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(NhaCungCap ncc) {
        String sql = "INSERT INTO nhacungcap (maNCC, tenNCC, diaChi) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ncc.getMaNCC());
            stmt.setString(2, ncc.getTenNCC());
            stmt.setString(3, ncc.getDiaChi());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(NhaCungCap ncc) {
        String sql = "UPDATE nhacungcap SET tenNCC = ?, diaChi = ? WHERE maNCC = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setString(3, ncc.getMaNCC());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
