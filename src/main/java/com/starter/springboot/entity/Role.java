package com.starter.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;   //ROLE_USER or ROLE_ADMIN


    @ManyToMany(mappedBy = "roles")
    private Set<User>  users = new HashSet<>();
}
