package com.example.adapter.adapters;

import com.example.adapter.adaptee.NhanVienDAO;
import com.example.adapter.target.NhanVienDatabase;
import com.example.model.NhanVien.NhanVien;

import java.util.List;

public class NhanVienDatabaseAdapter implements NhanVienDatabase {

    private final NhanVienDAO nhanVienDAO;

    public NhanVienDatabaseAdapter() {
        this.nhanVienDAO = new NhanVienDAO(); // adaptee
    }

    @Override
    public List<NhanVien> getAll() {
        return nhanVienDAO.findAll();
    }

    @Override
    public void add(NhanVien nv) {
        nhanVienDAO.insert(nv);
    }

    @Override
    public void update(NhanVien nv) {
        nhanVienDAO.update(nv);
    }
}