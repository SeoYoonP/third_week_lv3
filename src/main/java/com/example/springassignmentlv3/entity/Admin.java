package com.example.springassignmentlv3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AdminRoleEnum role;

    public Admin(String email, String department, String password, AdminRoleEnum roleEnum) {
        this.email = email;
        this.department = department;
        this.password = password;
        this.role = roleEnum;
    }
}
