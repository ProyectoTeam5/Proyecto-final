package com.tukiservice.models.user;

import com.tukiservice.models.roles.RolesService;
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
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String email;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_service")
    private Date dateService;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = AddressService.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<AddressService> address;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = RolesService.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RolesService> roles;

}