package com.tukiservice.models;

import java.util.Set;

import com.tukiservice.models.supplier.SupplierEntity;
import com.tukiservice.models.user.UserEntity;

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
    private int admin_id;


    private String admin_name;


    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = UserEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_admin", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<UserEntity> users;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = SupplierEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "supplier_admin", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<SupplierEntity> suppliers;
}