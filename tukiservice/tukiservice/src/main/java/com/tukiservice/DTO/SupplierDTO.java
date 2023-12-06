package com.tukiservice.DTO;
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

    private String profession;

    private Set<String> roles;
}
