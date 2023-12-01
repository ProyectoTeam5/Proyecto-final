package com.tukiservice.models.user;

import com.tukiservice.models.supplier.Service;
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

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_service;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = AddressService.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<AddressService> address;

     @OneToMany(fetch = FetchType.EAGER, targetEntity = Service.class, cascade = CascadeType.PERSIST)
     @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
     private Set<Service> roles;

}