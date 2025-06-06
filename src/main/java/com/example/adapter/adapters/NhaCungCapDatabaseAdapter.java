package com.example.adapter.adapters;

import com.example.adapter.adaptee.NhaCungCapDAO;
import com.example.adapter.target.NhaCungCapDatabase;
import com.example.model.NhaCungCap.NhaCungCap;

import java.util.List;

public class NhaCungCapDatabaseAdapter implements NhaCungCapDatabase {
    private NhaCungCapDAO dao = new NhaCungCapDAO();

    @Override
    public List<NhaCungCap> getAll() {
        return dao.findAll();
    }

    @Override
    public void add(NhaCungCap ncc) {
        dao.insert(ncc);
    }

    @Override
    public void update(NhaCungCap ncc) {
        dao.update(ncc);
    }

    @Override
    public void delete(String maNCC) {
        dao.delete(maNCC);
    }

}
