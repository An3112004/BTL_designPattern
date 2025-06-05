package com.example.adapter.target;

import com.example.model.NhaCungCap.NhaCungCap;

import java.util.List;

public interface NhaCungCapDatabase {
    List<NhaCungCap> getAll();
    void add(NhaCungCap ncc);
    void update(NhaCungCap ncc);
}
