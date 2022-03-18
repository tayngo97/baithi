package com.example.demo.entity.doan;

import com.example.demo.entity.doan.DoAn;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class LoaiBanh {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    private String tenLoaiBanh;
//
//    @OneToMany(mappedBy = "banhNgotMan")
//    @JsonBackReference
//    private List<DoAn> doAn;
//
//    public LoaiBanh(Integer id, String tenLoaiBanh, List<DoAn> doAn) {
//        this.id = id;
//        this.tenLoaiBanh = tenLoaiBanh;
//        this.doAn = doAn;
//    }
//
//    public LoaiBanh() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTenLoaiBanh() {
//        return tenLoaiBanh;
//    }
//
//    public void setTenLoaiBanh(String tenLoaiBanh) {
//        this.tenLoaiBanh = tenLoaiBanh;
//    }
//
//    public List<DoAn> getDoAn() {
//        return doAn;
//    }
//
//    public void setDoAn(List<DoAn> doAn) {
//        this.doAn = doAn;
//    }
}
