package com.tukiservice.service.user;


import com.tukiservice.models.user.UserEntity;

import java.util.List;

public interface IServiceUser {

    public void createUser(UserEntity userEntity);

    public List<?> findAllUser();

    public UserEntity findById(Long id);

}
