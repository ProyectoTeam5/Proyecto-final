package com.tukiservice.service.admin;


import com.tukiservice.models.AdminEntity;
import com.tukiservice.models.DTO.AdminEntityDTO;

import java.util.List;

public interface IServiceAdmin {

    public void createAdmin(AdminEntityDTO admin);

    public List<AdminEntity> findAllAdmin();

    public void deleteAdminById(Long id);
}
