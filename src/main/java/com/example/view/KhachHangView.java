package com.example.view;

import com.example.adapter.adaptee.KhachHangDAO;
import com.example.adapter.adapters.KhachHangDatabaseAdapter;
import com.example.model.KhachHang.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class KhachHangView extends JPanel {
    private JTextField txtMaKH, txtTenKH;
    private JComboBox<String> cbLoai;
    private JButton btnThem, btnSua , btnXoa;
    private JTable table;
    private DefaultTableModel model;
    private KhachHangDatabaseAdapter adapter = new KhachHangDatabaseAdapter();  // Adapter thay controller

    public KhachHangView() {
        setLayout(new BorderLayout());

        // Tạo tiêu đề
        JLabel titleLabel = new JLabel("Quản lý Khách Hàng");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Tạo input panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        txtMaKH = new JTextField(10);
        txtTenKH = new JTextField(10);
        cbLoai = new JComboBox<>(new String[]{"Khách hàng cá nhân", "Khách hàng doanh nghiệp"});
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xoá");

        inputPanel.add(new JLabel("Mã KH:"));
        inputPanel.add(txtMaKH);
        inputPanel.add(new JLabel("Tên KH:"));
        inputPanel.add(txtTenKH);
        inputPanel.add(new JLabel("Loại:"));
        inputPanel.add(cbLoai);
        inputPanel.add(btnThem);
        inputPanel.add(btnSua);
        inputPanel.add(btnXoa);

        // Gộp tiêu đề và input panel vào 1 panel chứa BorderLayout
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(new Object[]{"Mã KH", "Tên KH", "Loại"}, 0);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Load dữ liệu
        loadTable();

        // Button Thêm
        btnThem.addActionListener(e -> {
            String ma = txtMaKH.getText().trim();
            String ten = txtTenKH.getText().trim();
            if (ma.isEmpty() || ten.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // Tạo KhachHang thông qua Factory
            KhachHangFactory factory = getSelectedFactory();
            KhachHang kh = factory.taoKhachHang(ma, ten);

            // Thêm thông qua Adapter
            adapter.add(kh);
            clearInput();
            loadTable();
        });

        // Button Sửa
        btnSua.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
                return;
            }

            String ma = txtMaKH.getText().trim();
            String ten = txtTenKH.getText().trim();
            if (ma.isEmpty() || ten.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // Tạo KhachHang mới để cập nhật
            KhachHangFactory factory = getSelectedFactory();
            KhachHang kh = factory.taoKhachHang(ma, ten);

            adapter.update(kh);
            clearInput();
            loadTable();
        });

        btnXoa.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xoá");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá khách hàng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) return;

            String maKH = model.getValueAt(row, 0).toString();
            adapter.delete(maKH);
            clearInput();
            loadTable();
        });


        // Click bảng -> hiện dữ liệu lên form
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtMaKH.setText(model.getValueAt(row, 0).toString());
                txtTenKH.setText(model.getValueAt(row, 1).toString());
                cbLoai.setSelectedItem(model.getValueAt(row, 2).toString());
            }
        });
    }

    private void clearInput() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        cbLoai.setSelectedIndex(0);
        table.clearSelection();
    }

    private void loadTable() {
        model.setRowCount(0);
        List<KhachHang> danhSach = adapter.getAll();
        for (KhachHang kh : danhSach) {
            model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getLoaiKH()});
        }
    }

    private KhachHangFactory getSelectedFactory() {
        String loai = cbLoai.getSelectedItem().toString();
        if (loai.equalsIgnoreCase("Khách hàng doanh nghiệp")) {
            return new KHDoanhNghiepFactory();
        } else {
            return new KHCaNhanFactory();
        }
    }
}
