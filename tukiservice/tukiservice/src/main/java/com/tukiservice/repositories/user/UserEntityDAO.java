package com.tukiservice.repositories.user;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tukiservice.models.Erole;
import com.tukiservice.models.supplier.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.tukiservice.DTO.UserEntityDTO;
import com.tukiservice.models.user.AddressEnum;
import com.tukiservice.models.user.AddressService;
import com.tukiservice.models.user.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Service
public class UserEntityDAO {

    @Autowired
    UserEntityRepository userER;

    @Autowired
    @PersistenceContext
    EntityManager em;

    public void createUsers(UserEntityDTO userDTO) {

        Set<AddressService> AddressD = userDTO.getAddress().stream()
                .map( r -> AddressService.builder()
                        .address(AddressEnum.valueOf(r)).build())
                .collect(Collectors.toSet());
        Set<Service> Roles = userDTO.getRoles().stream()
                .map(r-> Service.builder()
                        .rol(Erole.valueOf(r)).build()).collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .date_service(userDTO.getDate_service())
                .address(AddressD)
                .roles(Roles)
                .build();

        userER.save(userEntity);
        log.info("Información del usuario procesada...");
    }

    public List<UserEntity> getAllUsers(){

        log.info("Información de todos los Usuarios procesada...");
        return (List<UserEntity>) userER.findAll();
    }

    public UserEntity getUsersById(Long id){

        log.info("Información del usuario procesada...");
        return userER.findById(id).orElse(null);
    }

    public UserEntity getUserByName(String name){

        log.info("Información del usuario procesada...");
        String query = "FROM UserEntity WHERE name=:name";
        return (UserEntity) em.createQuery(query).setParameter("name",name).getSingleResult();
    }

    public void modifyUsers(UserEntity userentity) {

        userentity.setName(userentity.getName());
        userentity.setEmail(userentity.getEmail());
        userentity.setPassword(userentity.getPassword());
        userentity.setDate_service(userentity.getDate_service());
        userentity.setAddress(userentity.getAddress());

        userER.save(userentity);
        log.info("Modificación del usuario procesada...");
    }

    public void deleteUsers(Long id) {
        userER.delete(userER.findById(id).orElse(null));
        log.info("Eliminación del usuario procesada...");
    }



}