package com.tukiservice.repositories.admin;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.tukiservice.DTO.AdminEntityDTO;
import com.tukiservice.models.AdminEntity;
import com.tukiservice.models.roles.Erole;
import com.tukiservice.models.roles.RolesService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AdminEntityDao {
    @Autowired
    AdminEntityRepository adminEntityRepository;

    @PersistenceContext
    EntityManager em;

    public void createAdmin (AdminEntityDTO adminDTO){
        
        Set<RolesService> roles = adminDTO.getRole().stream().map(r->RolesService.builder().roles(Erole.valueOf(r)).build()).collect(Collectors.toSet());

        AdminEntity admin = AdminEntity.builder()
            .adminName(adminDTO.getAdminName())
            .password(adminDTO.getPassword())
            .role(roles)
            .build();

            adminEntityRepository.save(admin);
    }

    public List<AdminEntity> findAllEntities(){

        return (List<AdminEntity>)adminEntityRepository.findAll();

    }

    public void deleteAdmin(Long id){

        adminEntityRepository.delete(adminEntityRepository.findById(id).orElse(null));

    }

}