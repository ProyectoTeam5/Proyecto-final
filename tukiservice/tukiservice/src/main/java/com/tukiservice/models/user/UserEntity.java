package com.tukiservice.models.user;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Data
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;


    private String name;


    private String email;


    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_service;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = AddressService.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<AddressService> address;

    // @OneToMany(fetch = FetchType.EAGER, targetEntity = AddressEnum.class, cascade = CascadeType.PERSIST)
    // @JoinTable(name = "user_supplier", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    // private Set<String> supplier_id;

}