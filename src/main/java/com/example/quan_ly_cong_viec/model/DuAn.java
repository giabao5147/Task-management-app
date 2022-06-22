package com.example.quan_ly_cong_viec.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "du_an")
public class DuAn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_leader")
    @Cascade(CascadeType.DETACH)
    private NguoiDung leader;

    @Column(name = "ten_du_an")
    private String tenDuAn;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "tien_do")
    private BigDecimal tienDo;

    @Column(name = "ngay_bat_dau")
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;

    @OneToMany(mappedBy = "duAn", fetch = FetchType.EAGER)
    private Set<ThongTinDuAn> danhSachThongTinDuAn;

    public DuAn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NguoiDung getLeader() {
        return leader;
    }

    public void setLeader(NguoiDung leader) {
        this.leader = leader;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public BigDecimal getTienDo() {
        return tienDo;
    }

    public void setTienDo(BigDecimal tienDo) {
        this.tienDo = tienDo;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Set<ThongTinDuAn> getDanhSachThongTinDuAn() {
        return danhSachThongTinDuAn;
    }

    public void setDanhSachThongTinDuAn(Set<ThongTinDuAn> danhSachThongTinDuAn) {
        this.danhSachThongTinDuAn = danhSachThongTinDuAn;
    }
}
