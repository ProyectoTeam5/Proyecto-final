package com.tukiservice.service.user;



import com.tukiservice.models.DTO.UserEntityDTO;
import com.tukiservice.models.user.UserEntity;

import java.util.List;

public interface IUserService {

    public List<UserEntity> findAllUser();

    public UserEntity findUserById(Long id);
    public void createUser(UserEntityDTO supplierDTO);

    public void deleteUser(Long id);

    public List<UserEntity> findUserByName(String userName);

    public boolean verifyUser(UserEntity userEntity);
}
