package com.example.tukiservicios.tukiservicios.models.supplier;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name="supplier_name")
    private String supplierName;
    @NonNull
    private String foto;
    @NonNull
    @Email
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String resume;
    @NonNull
    private float price;
    @NonNull
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "work_status")
    private String workStatus;
    @NonNull
    @OneToOne(fetch = FetchType.EAGER, targetEntity = ProfessionEnum.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "supplier_service", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_service"))
    private Set<ProfessionEnum> profession;
    @NonNull
    @OneToMany(fetch = FetchType.EAGER, targetEntity = UserEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "supplier_user", joinColumns = @JoinColumn(name = "id"),  inverseJoinColumns = @JoinColumn(name = "id_user"))
    private  Set<UserEntity> clientes;


}
