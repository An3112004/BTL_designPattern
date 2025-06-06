package com.example.adapter.target;

import com.example.model.KhachHang.KhachHang;

import java.util.List;

public interface KhachHangDatabase {
    List<KhachHang> getAll();
    void add(KhachHang khachHang);
    void update(KhachHang khachHang);
    void delete(String maKH);

}
