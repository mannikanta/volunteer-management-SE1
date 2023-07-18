package com.volunteer.management.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "adminId")
    private String adminId;

    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private String role;

}
