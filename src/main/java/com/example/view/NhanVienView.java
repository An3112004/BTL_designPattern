// KhachHangView.java (1 class duy nhất)
package com.example.view;

import com.example.adapter.adapters.NhanVienDatabaseAdapter;
import com.example.model.NhanVien.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class NhanVienView extends JPanel {
    private JTextField txtMaKH, txtTenKH;
    private JComboBox<String> cbLoai;
    private JButton btnThem, btnSua , btnXoa;
    private JTable table;
    private DefaultTableModel model;
    private NhanVienDatabaseAdapter adapter = new NhanVienDatabaseAdapter();
    private int editingRow = -1;

    public NhanVienView() {
        setLayout(new BorderLayout());

// Tạo tiêu đề
        JLabel titleLabel = new JLabel("Quản lý Nhân Viên");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

// Panel nhập liệu
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        txtMaKH = new JTextField(10);
        txtTenKH = new JTextField(10);
        cbLoai = new JComboBox<>(new String[]{"Nhân viên kho", "Nhân viên bán hàng"});
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");

        inputPanel.add(new JLabel("Mã NV:"));
        inputPanel.add(txtMaKH);
        inputPanel.add(new JLabel("Tên NV:"));
        inputPanel.add(txtTenKH);
        inputPanel.add(new JLabel("Vai Trò:"));
        inputPanel.add(cbLoai);
        inputPanel.add(btnThem);
        inputPanel.add(btnSua);
        inputPanel.add(btnXoa);

// Gộp tiêu đề và inputPanel vào topPanel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);


        // Table
        model = new DefaultTableModel(new Object[]{"Mã NV", "Tên NV", "Vai Trò"}, 0);
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

            // Xác định loại nhân viên
            String loai = cbLoai.getSelectedItem().toString();

            // Chọn builder phù hợp
            NhanVienBuilder builder;
            if (loai.equals("Nhân viên kho")) {
                builder = new NhanVienKhoBuilder();
            } else {
                builder = new NhanVienBanHangBuilder();
            }

            // Sử dụng Director để build nhân viên
            NhanVienDirector director = new NhanVienDirector(builder);
            director.make(ma, ten, loai.equals("Nhân viên kho") ? "NhanVienKho" : "NhanVienBanHang");

            // Lấy đối tượng nhân viên sau khi build
            NhanVien nv = builder.build(ma , ten);

            // Thêm vào adapter hoặc danh sách xử lý (ví dụ controller hoặc list)
            adapter.add(nv);  // hoặc controller.themNhanVien(nv);

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

            // Lấy vai trò từ combobox
            String loai = cbLoai.getSelectedItem().toString();

            // Khởi tạo builder phù hợp
            NhanVienBuilder builder;
            if (loai.equals("Nhân viên kho")) {
                builder = new NhanVienKhoBuilder();
            } else {
                builder = new NhanVienBanHangBuilder();
            }

            // Dùng Director để build lại nhân viên
            NhanVienDirector director = new NhanVienDirector(builder);
            director.make(ma, ten, loai.equals("Nhân viên kho") ? "NhanVienKho" : "NhanVienBanHang");

            // Lấy nhân viên đã build
            NhanVien nv = builder.build(ma , ten);
            System.out.println(nv.getMaNV());
            // Gọi controller để sửa
            adapter.update(nv);

            clearInput();
            loadTable();
        });

        btnXoa.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc muốn xóa nhân viên này?",
                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String maNV = model.getValueAt(row, 0).toString();
                adapter.delete(maNV);
                clearInput();
                loadTable();
            }
        });



        // Click trên bảng -> hiển thị dữ liệu
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
        for (NhanVien nv : adapter.getAll()) {
            model.addRow(new Object[]{nv.getMaNV() , nv.getTenNV() , nv.getVaiTro()});
        }
    }

    private NhanVienBuilder getSelectedBuilder() {
        String loai = cbLoai.getSelectedItem().toString();
        if (loai.equals("Nhân viên kho")) {
            return new NhanVienKhoBuilder();
        } else {
            return new NhanVienBanHangBuilder();
        }
    }

}

