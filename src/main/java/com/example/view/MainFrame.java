package com.example.view;

import javax.swing.*;
import java.awt.*;
import com.example.view.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        setTitle("Quản lý hệ thống");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo các nút chức năng
        JButton btnKhachHang = new JButton("Quản lý khách hàng");
        JButton btnNhanVien = new JButton("Quản lý nhân viên");
        JButton btnSanPham = new JButton("Quản lý sản phẩm");
        JButton btnNhaCungCap = new JButton("Quản lý nhà cung cấp");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(btnKhachHang);
        buttonPanel.add(btnNhanVien);
        buttonPanel.add(btnSanPham);
        buttonPanel.add(btnNhaCungCap);

        // Tạo panel chính chứa các view
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(new KhachHangView(), "KhachHang");
        cardPanel.add(new NhanVienView(), "NhanVien");
        cardPanel.add(new SanPhamView(), "SanPham");
        cardPanel.add(new NhaCungCapView(), "NhaCungCap");

        // Gán hành động cho các nút
        btnKhachHang.addActionListener(e -> cardLayout.show(cardPanel, "KhachHang"));
        btnNhanVien.addActionListener(e -> cardLayout.show(cardPanel, "NhanVien"));
        btnSanPham.addActionListener(e -> cardLayout.show(cardPanel, "SanPham"));
        btnNhaCungCap.addActionListener(e -> cardLayout.show(cardPanel, "NhaCungCap"));
        // Gộp các thành phần
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
    }
}
