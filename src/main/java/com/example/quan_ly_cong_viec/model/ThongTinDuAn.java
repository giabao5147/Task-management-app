package com.example.quan_ly_cong_viec.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "thong_tin_du_an")
public class ThongTinDuAn implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_du_an")
    @Cascade(CascadeType.DELETE)
    private DuAn duAn;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    @Cascade(CascadeType.DELETE)
    private NguoiDung nguoiDung;

    @Column(name = "cong_viec", length = 65535, columnDefinition = "Text")
    private String congViec;

    @Column(name = "tien_do")
    private BigDecimal tienDo;

    public ThongTinDuAn() {
    }

    public ThongTinDuAn(DuAn duAn, NguoiDung nguoiDung) {
        this.duAn = duAn;
        this.nguoiDung = nguoiDung;
    }

    public DuAn getDuAn() {
        return duAn;
    }

    public void setDuAn(DuAn duAn) {
        this.duAn = duAn;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public BigDecimal getTienDo() {
        return tienDo;
    }

    public void setTienDo(BigDecimal tienDo) {
        this.tienDo = tienDo;
    }
}
