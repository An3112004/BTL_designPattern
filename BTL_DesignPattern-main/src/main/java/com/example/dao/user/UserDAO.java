package com.example.dao.user;

import com.example.dao.ConnectionManager;
import com.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class UserDAO {

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM admin";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("idAdmin"));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trong thực tế, bạn có thể ném exception hoặc log để xử lý ở tầng Service
        }
        return users;
    }

}
