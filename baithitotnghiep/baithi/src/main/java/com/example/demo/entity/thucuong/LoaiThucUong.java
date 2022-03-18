package com.example.demo.entity.thucuong;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
@Entity
public class LoaiThucUong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tenLoaiThucUong;

//    @OneToMany(mappedBy = "loaiThucUong")
//    @JsonBackReference
//    private List<ThucUong> thucUong;
}
