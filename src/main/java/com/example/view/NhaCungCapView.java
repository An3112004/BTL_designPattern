package com.example.view;

import com.example.model.NhaCungCap.NhaCungCap;
import com.example.model.NhaCungCap.NhaCungCapManager;
import com.example.adapter.adapters.NhaCungCapDatabaseAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class NhaCungCapView extends JPanel {
    private JTextField txtMaNCC, txtTenNCC, txtDiaChi;
    private JButton btnThem, btnSua , btnXoa;
    private JTable table;
    private DefaultTableModel model;
    private NhaCungCapDatabaseAdapter adapter = new NhaCungCapDatabaseAdapter();

    public NhaCungCapView() {
        setLayout(new BorderLayout());

        // Tiêu đề
        JLabel titleLabel = new JLabel("Quản lý Nhà Cung Cấp");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        txtMaNCC = new JTextField(10);
        txtTenNCC = new JTextField(10);
        txtDiaChi = new JTextField(15);
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");

        inputPanel.add(new JLabel("Mã NCC:"));
        inputPanel.add(txtMaNCC);
        inputPanel.add(new JLabel("Tên NCC:"));
        inputPanel.add(txtTenNCC);
        inputPanel.add(new JLabel("Địa chỉ:"));
        inputPanel.add(txtDiaChi);
        inputPanel.add(btnThem);
        inputPanel.add(btnSua);
        inputPanel.add(btnXoa);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(new Object[]{"Mã NCC", "Tên NCC", "Địa chỉ"}, 0);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Load dữ liệu
        loadTable();

        // Thêm nhà cung cấp
        btnThem.addActionListener(e -> {
            String ma = txtMaNCC.getText().trim();
            String ten = txtTenNCC.getText().trim();
            String diaChi = txtDiaChi.getText().trim();

            if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // Tạo nhà cung cấp thông qua Singleton Factory
            NhaCungCap ncc = NhaCungCapManager.getInstance().taoNhaCungCap(ma, ten, diaChi);

            // Thêm vào DB
            adapter.add(ncc);

            clearInput();
            loadTable();
        });

        // Sửa nhà cung cấp
        btnSua.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
                return;
            }

            String ma = txtMaNCC.getText().trim();
            String ten = txtTenNCC.getText().trim();
            String diaChi = txtDiaChi.getText().trim();

            if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            // Tạo lại đối tượng từ Factory
            NhaCungCap ncc = NhaCungCapManager.getInstance().taoNhaCungCap(ma, ten, diaChi);

            adapter.update(ncc);
            clearInput();
            loadTable();
        });

        btnXoa.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
                return;
            }

            String ma = txtMaNCC.getText().trim();

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhà cung cấp này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                adapter.delete(ma);
                clearInput();
                loadTable();
            }
        });


        // Hiển thị khi click bảng
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtMaNCC.setText(model.getValueAt(row, 0).toString());
                txtTenNCC.setText(model.getValueAt(row, 1).toString());
                txtDiaChi.setText(model.getValueAt(row, 2).toString());
            }
        });
    }

    private void clearInput() {
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        table.clearSelection();
    }

    private void loadTable() {
        model.setRowCount(0);
        List<NhaCungCap> list = adapter.getAll();
        for (NhaCungCap ncc : list) {
            model.addRow(new Object[]{ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi()});
        }
    }
}
