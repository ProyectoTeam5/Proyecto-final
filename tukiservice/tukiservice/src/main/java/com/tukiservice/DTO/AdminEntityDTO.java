package com.tukiservice.DTO;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AdminEntityDTO {
    
    private String adminName;
    private String password;
    private Set<String> role;

}
