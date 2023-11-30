package com.tukiservice.repositories.user;

import org.springframework.data.repository.CrudRepository;

import com.tukiservice.models.user.AddressService;

public interface AddressServiceRepository extends CrudRepository<AddressService, Long> {
    
}
