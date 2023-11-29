package com.tukiservice.models.supplier;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Size(max = 30)
    @Column(name="supplier_name")
    private String supplierName;

    @NotNull
    private String foto;

    @NotNull
    @Email
    @Size(max = 80)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String resume;


    @NotNull
    @Column(name = "contact_number")
    private String contactNumber;

    @NotNull
    @Column(name = "work_status")
    private String workStatus;

    @NotNull
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Service.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "supplier_profession", joinColumns = @JoinColumn(name = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> profession;

 /* @NotNull
   @OneToMany(fetch = FetchType.EAGER, targetEntity = UserEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "supplier_user", joinColumns = @JoinColumn(name = "id"),  inverseJoinColumns = @JoinColumn(name = "id_user"))
    private  Set<UserEntity> clients;*/


}
