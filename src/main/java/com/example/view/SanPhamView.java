package com.example.view;

import com.example.adapter.adapters.SanPhamDatabaseAdapter;
import com.example.model.SanPham.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SanPhamView extends JPanel {
    private JTextField txtMaSP, txtTenSP, txtGia;
    private JComboBox<String> cbLoai;
    private JButton btnThem, btnSua , btnXoa;
    private JTable table;
    private DefaultTableModel model;
    private SanPhamDatabaseAdapter adapter = new SanPhamDatabaseAdapter();

    public SanPhamView() {
        setLayout(new BorderLayout());

        // Tạo tiêu đề
        JLabel titleLabel = new JLabel("Quản lý Sản Phẩm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Tạo input panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        txtMaSP = new JTextField(10);
        txtTenSP = new JTextField(10);
        txtGia = new JTextField(10);
        cbLoai = new JComboBox<>(new String[]{"Đồ điện tử", "Quần áo"});
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xoá");

        inputPanel.add(new JLabel("Mã SP:"));
        inputPanel.add(txtMaSP);
        inputPanel.add(new JLabel("Tên SP:"));
        inputPanel.add(txtTenSP);
        inputPanel.add(new JLabel("Giá:"));
        inputPanel.add(txtGia);
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
        model = new DefaultTableModel(new Object[]{"Mã SP", "Tên SP", "Loại", "Giá"}, 0);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Load dữ liệu
        loadTable();

        // Thêm sản phẩm
        btnThem.addActionListener(e -> {
            String ma = txtMaSP.getText().trim();
            String ten = txtTenSP.getText().trim();
            String giaText = txtGia.getText().trim();

            if (ma.isEmpty() || ten.isEmpty() || giaText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            double gia;
            try {
                gia = Double.parseDouble(giaText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Giá không hợp lệ");
                return;
            }

            String loai = cbLoai.getSelectedItem().toString();
            SanPhamFactory factory = SanPhamFactoryProducer.getFactory(loai);
            SanPham sp = factory.taoSanPham(ma, ten, gia);
            adapter.add(sp);

            clearInput();
            loadTable();
        });

        // Sửa sản phẩm
        btnSua.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
                return;
            }

            String ma = txtMaSP.getText().trim();
            String ten = txtTenSP.getText().trim();
            String giaText = txtGia.getText().trim();

            if (ma.isEmpty() || ten.isEmpty() || giaText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                return;
            }

            double gia;
            try {
                gia = Double.parseDouble(giaText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Giá không hợp lệ");
                return;
            }

            String loai = cbLoai.getSelectedItem().toString();

            SanPhamFactory factory = SanPhamFactoryProducer.getFactory(loai);
            SanPham sp = factory.taoSanPham(ma, ten, gia);

            adapter.update(sp);

            clearInput();
            loadTable();
        });

        btnXoa.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xoá");
                return;
            }

            String maSP = model.getValueAt(row, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá sản phẩm này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                adapter.delete(maSP);
                clearInput();
                loadTable();
            }
        });


        // Click table để đổ dữ liệu lên form
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtMaSP.setText(model.getValueAt(row, 0).toString());
                txtTenSP.setText(model.getValueAt(row, 1).toString());
                cbLoai.setSelectedItem(model.getValueAt(row, 2).toString());
                txtGia.setText(model.getValueAt(row, 3).toString());
            }
        });
    }

    private void clearInput() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGia.setText("");
        cbLoai.setSelectedIndex(0);
        table.clearSelection();
    }

    private void loadTable() {
        model.setRowCount(0);
        for (SanPham sp : adapter.getAll()) {
            model.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), sp.getGia()});
        }
    }
}
