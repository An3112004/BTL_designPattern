package com.example.adapter.target;

import com.example.model.NhanVien.NhanVien;

import java.util.List;

public interface NhanVienDatabase {
    List<NhanVien> getAll();
    void add(NhanVien nv);
    void update(NhanVien nv);
    void delete(String maNV);
}
