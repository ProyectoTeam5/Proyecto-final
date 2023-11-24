package com.example.tukiservicios.tukiservicios.models;

import com.example.tukiservicios.tukiservicios.models.SupplierEntityEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class SupplierEntity {

    @Id
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name="supplier_name")
    private String supplierName;
    @NonNull
    @Column(name = "foto")
    private String foto;
    @NonNull
    @Email
    @Column(name = "email")
    private String email;
    @NonNull
    @Column(name="password")
    private String password;
    @NonNull
    @Column(name="resume")
    private String resume;
    @NonNull
    @Column(name = "price")
    private float price;
    @NonNull
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "work_status")
    private String workStatus;
    @NonNull
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Id
    @NonNull
    @Column(name = "id_service")
    private int idService;

    @NonNull
    @OneToOne
    @Enumerated(EnumType.STRING)
    private SupplierEntityEnum profession;


}
