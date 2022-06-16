package com.stdio.esm.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
/**
 * @author AnhKhoa
 * @since 19/05/2022 - 11:11
 */
@Entity
@Table(name ="employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address",length = 255)
    private String address;

    @Column(name = "email",length = 255,unique = true)
    private String email;

    @Column(name = "avatar_img")
    private String avatar;

    @Column(name = "start_date")
    private Instant start_date;

    @CreationTimestamp
    @Column(name = "createAt",nullable = false,updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "modifyAt",nullable = false)
    private Instant modifyAt;

    @Column(name ="deleteFlag")
    private Boolean deleteFlag;

}
