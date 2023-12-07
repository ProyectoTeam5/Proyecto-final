package com.tukiservice.models.DTO;

import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntityDTO {

    private String name;
    private String email;
    private String password;
    private Date dateService;
    private String address;
    private Set<String> roles;
}
