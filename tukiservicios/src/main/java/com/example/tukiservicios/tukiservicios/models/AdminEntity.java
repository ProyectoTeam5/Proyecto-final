package com.tukiservices.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;

    @NotBlank
    @Size(max = 255)
    private String admin_name;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "admin", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Supplier.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "admin", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<Supplier> suppliers;
}