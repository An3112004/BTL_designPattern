package com.example.adapter.adapters;

import com.example.adapter.adaptee.KhachHangDAO;
import com.example.adapter.target.KhachHangDatabase;
import com.example.model.KhachHang.KhachHang;

import java.util.List;

public class KhachHangDatabaseAdapter implements KhachHangDatabase {

    private final KhachHangDAO dao = new KhachHangDAO();


    @Override
    public List<KhachHang> getAll() {
        return dao.findAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        dao.insert(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        dao.update(khachHang);
    }

    @Override
    public void delete(String maKH) {
        dao.delete(maKH);
    }

}
