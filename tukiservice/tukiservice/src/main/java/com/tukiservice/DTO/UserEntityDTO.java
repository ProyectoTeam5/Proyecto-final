package com.tukiservice.DTO;

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
    private Date date_service;
    private Set<String> address;
}
