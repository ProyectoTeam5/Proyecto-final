package com.tukiservice.models.supplier;

import java.util.Set;

import com.tukiservice.models.roles.RolesService;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;


    @Column(name="supplier_name")
    private String supplierName;

    private String foto;

    private String email;

    private String password;

    private String resume;

    @Column(name = "contact_number")
    private String contactNumber;


    @Column(name = "work_status")
    private String workStatus;

    private String profession;



    @OneToMany(fetch = FetchType.EAGER, targetEntity = RolesService.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "supplier_roles", joinColumns = @JoinColumn(name = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))

    private Set<RolesService> roles;


}
