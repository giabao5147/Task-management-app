package com.example.quan_ly_cong_viec.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "nguoi_dung")
public class NguoiDung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "mat_khau")
    private String matKhau;

    @ManyToOne
    @Cascade(CascadeType.DETACH)
    @JoinColumn(name = "id_phan_quyen")
    private PhanQuyen phanQuyen;

    @Column(name = "token")
    private String token;

    @OneToMany(mappedBy = "leader", fetch = FetchType.EAGER)
    private Set<DuAn> danhSachDuAnLeader;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.EAGER)
    private Set<ThongTinDuAn> danhSachThongTinDuAn;

    public NguoiDung() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public PhanQuyen getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(PhanQuyen phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<DuAn> getDanhSachDuAnLeader() {
        return danhSachDuAnLeader;
    }

    public void setDanhSachDuAnLeader(Set<DuAn> danhSachDuAnLeader) {
        this.danhSachDuAnLeader = danhSachDuAnLeader;
    }

    public Set<ThongTinDuAn> getDanhSachThongTinDuAn() {
        return danhSachThongTinDuAn;
    }

    public void setDanhSachThongTinDuAn(Set<ThongTinDuAn> danhSachThongTinDuAn) {
        this.danhSachThongTinDuAn = danhSachThongTinDuAn;
    }
}
