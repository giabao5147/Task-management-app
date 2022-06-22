package com.example.quan_ly_cong_viec.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "phan_quyen")
public class PhanQuyen implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ten_phan_quyen")
    private String tenPhanQuyen;

    @OneToMany(mappedBy = "phanQuyen", fetch = FetchType.EAGER)
    Set<NguoiDung> danhSachNguoiDung;

    public PhanQuyen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhanQuyen() {
        return tenPhanQuyen;
    }

    public void setTenPhanQuyen(String tenPhanQuyen) {
        this.tenPhanQuyen = tenPhanQuyen;
    }

    public Set<NguoiDung> getDanhSachNguoiDung() {
        return danhSachNguoiDung;
    }

    public void setDanhSachNguoiDung(Set<NguoiDung> danhSachNguoiDung) {
        this.danhSachNguoiDung = danhSachNguoiDung;
    }
}
