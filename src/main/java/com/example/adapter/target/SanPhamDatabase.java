package com.example.adapter.target;

import com.example.model.SanPham.SanPham;

import java.util.List;

public interface SanPhamDatabase {
    List<SanPham> getAll();
    void add(SanPham sanPham);
    void update(SanPham sanPham);
}
