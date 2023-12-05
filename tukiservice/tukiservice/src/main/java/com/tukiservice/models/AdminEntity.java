package com.tukiservice.models;

import java.util.Set;

import com.tukiservice.models.roles.RolesService;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;


@Entity
@Table(name="admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_name")
    private String adminName;
    
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RolesService.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "admin_roles", joinColumns = @JoinColumn(name = "admin_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RolesService> role;
    
}