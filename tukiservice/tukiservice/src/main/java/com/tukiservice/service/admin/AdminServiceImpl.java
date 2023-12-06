package com.tukiservice.service.admin;

import com.tukiservice.models.AdminEntity;
import com.tukiservice.models.DTO.AdminEntityDTO;
import com.tukiservice.models.roles.Erole;
import com.tukiservice.models.roles.RolesService;
import com.tukiservice.repositories.admin.AdminEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminServiceImpl implements IServiceAdmin{

    @Autowired
    AdminEntityRepository adminEntityRepository;
    @Override
    public void createAdmin(AdminEntityDTO adminDTO) {
        Set<RolesService> roles = adminDTO.getRole().stream().map(r->RolesService.builder().roles(Erole.valueOf(r)).build()).collect(Collectors.toSet());

        AdminEntity admin = AdminEntity.builder()
                .adminName(adminDTO.getAdminName())
                .password(adminDTO.getPassword())
                .role(roles)
                .build();

        adminEntityRepository.save(admin);

    }

    @Override
    public List<AdminEntity> findAllAdmin() {
        return (List<AdminEntity>)adminEntityRepository.findAll();
    }

    @Override
    public void deleteAdminById(Long id) {
        adminEntityRepository.delete(adminEntityRepository.findById(id).orElse(null));
    }
}
