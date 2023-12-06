package com.tukiservice.repositories.user;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tukiservice.models.roles.Erole;
import com.tukiservice.models.roles.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import com.tukiservice.DTO.UserEntityDTO;
import com.tukiservice.models.user.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Service
public class UserEntityDAO {

    @Autowired
    UserEntityRepository userER;


    @PersistenceContext
    EntityManager em;

    public void createUsers(UserEntityDTO userDTO) {



        Set<RolesService> Roles = userDTO.getRoles().stream()
                .map(r-> RolesService.builder()
                        .roles(Erole.valueOf(r)).build()).collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .dateService(userDTO.getDateService())
                .address(userDTO.getAddress())
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
        userentity.setDateService(userentity.getDateService());
        userentity.setAddress(userentity.getAddress());

        userER.save(userentity);
        log.info("Modificación del usuario procesada...");
    }

    public void deleteUsers(Long id) {
        userER.delete(userER.findById(id).orElse(null));
        log.info("Eliminación del usuario procesada...");
    }


    public boolean verifyUser(UserEntity userEntity) {
        String query = "FROM UserEntity WHERE email =:email AND password = :password";
        List<UserEntity> userList= em.createQuery(query)
                .setParameter("email",userEntity.getEmail())
                .setParameter("password",userEntity.getPassword())
                .getResultList();

        return !userList.isEmpty();

    }
}