package com.tukiservice.models.supplier;

import java.util.Set;

import com.tukiservice.models.roles.RolesService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;


    @NotBlank
    @Size(max = 255)
    @Column(name="supplier_name")
    private String supplierName;

    @Lob
    private String foto;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String resume;

    @NotBlank
    @Column(name = "contact_number")
    private String contactNumber;

    @NotBlank
    @Column(name = "work_status")
    private String workStatus;

    @NotBlank
    private String profession;


    @OneToMany(fetch = FetchType.EAGER, targetEntity = RolesService.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "supplier_roles", joinColumns = @JoinColumn(name = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RolesService> roles;


}
