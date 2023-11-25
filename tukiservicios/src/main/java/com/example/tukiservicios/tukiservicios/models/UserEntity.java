package com.example.tukiservicios.tukiservicios.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_service;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address_id;

    @OneToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private SupplierEntity supplier_id;

}
