package com.example.demo.entity.sachtruyen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SachTruyen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String maSanPham;
    private String tenSanPham;
    private String donGia;
    private String tinhTrang;
    private String ngayNhapHang;
    private Boolean checkFlag;


    private String tacGia;
    private String ngayXuatBan;
    private String theLoai;

    public SachTruyen(Integer id, String maSanPham, String tenSanPham, String donGia, String tinhTrang, String ngayNhapHang, String tacGia, String ngayXuatBan, String theLoai) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.tinhTrang = tinhTrang;
        this.ngayNhapHang = ngayNhapHang;
        this.tacGia = tacGia;
        this.ngayXuatBan = ngayXuatBan;
        this.theLoai = theLoai;
    }

    public SachTruyen() {
    }

    public Boolean getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Boolean checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNgayNhapHang() {
        return ngayNhapHang;
    }

    public void setNgayNhapHang(String ngayNhapHang) {
        this.ngayNhapHang = ngayNhapHang;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
