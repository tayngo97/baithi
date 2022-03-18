package com.example.demo.entity.thucuong;

import com.example.demo.entity.doan.LoaiBanh;

import javax.persistence.*;

@Entity
public class ThucUong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String maSanPham;
    private String tenSanPham;
    private String donGia;
    private String tinhTrang;
    private String ngayNhapHang;

    private String xuatXu;
    private Integer loaiThucUong;

    private Boolean checkFlag;

    public ThucUong(Integer id, String maSanPham, String tenSanPham, String donGia, String tinhTrang, String ngayNhapHang, String xuatXu, Integer loaiThucUong, Boolean checkFlag) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.tinhTrang = tinhTrang;
        this.ngayNhapHang = ngayNhapHang;
        this.xuatXu = xuatXu;
        this.loaiThucUong = loaiThucUong;
        this.checkFlag = checkFlag;
    }

    public ThucUong() {
    }


    //    @ManyToOne
//    @JoinColumn(name = "loai_thuc_uong", nullable = false)
//    private LoaiThucUong loaiThucUong;


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

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public Integer getLoaiThucUong() {
        return loaiThucUong;
    }

    public void setLoaiThucUong(Integer loaiThucUong) {
        this.loaiThucUong = loaiThucUong;
    }

    public Boolean getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Boolean checkFlag) {
        this.checkFlag = checkFlag;
    }
}
