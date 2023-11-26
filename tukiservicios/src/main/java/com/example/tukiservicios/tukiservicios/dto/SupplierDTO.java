package com.example.tukiservicios.tukiservicios.dto;


import com.example.tukiservicios.tukiservicios.models.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO {



    private String supplierName;

    private String foto;

    private String email;

    private String password;

    private String resume;

    private String contactNumber;

    private String workStatus;

    private Set<String> profession;

    //private  Set<String> clients;
}
