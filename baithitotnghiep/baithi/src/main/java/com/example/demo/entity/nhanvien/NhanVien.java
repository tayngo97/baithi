package com.example.demo.entity.nhanvien;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String maNhanVien;
    private String tenNhanVien;
    private String viTri;
    private Boolean checkFlag;


    public NhanVien() {
    }

    public NhanVien(Integer id, String maNhanVien, String tenNhanVien, String viTri) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.viTri = viTri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}
