package com.example.adapter.adapters;

import com.example.adapter.adaptee.SanPhamDAO;
import com.example.adapter.target.SanPhamDatabase;
import com.example.model.SanPham.SanPham;

import java.util.List;

public class SanPhamDatabaseAdapter implements SanPhamDatabase {

    SanPhamDAO sanPhamDAO = new SanPhamDAO();

    @Override
    public List<SanPham> getAll() {
        return sanPhamDAO.findAll();
    }

    @Override
    public void add(SanPham sanPham) {
        sanPhamDAO.insert(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamDAO.update(sanPham);
    }
}
