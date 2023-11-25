package com.example.tukiservicios.tukiservicios.models;

import java.util.Set;
import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;
import com.example.tukiservicios.tukiservicios.models.user.UserEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(max = 255)
    private String admin_name;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = UserEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "admin", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<UserEntity> users;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = SupplierEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "admin", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<SupplierEntity> suppliers;
}