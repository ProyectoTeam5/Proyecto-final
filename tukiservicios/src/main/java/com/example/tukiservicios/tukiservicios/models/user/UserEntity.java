package com.example.tukiservicios.tukiservicios.models.user;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;
import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_service;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = AddressEnum.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<AddressEnum> address;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = AddressEnum.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_supplier", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<SupplierEntity> supplier_id;

}