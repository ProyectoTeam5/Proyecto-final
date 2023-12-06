package com.tukiservice.service.user;

import com.tukiservice.models.DTO.UserEntityDTO;
import com.tukiservice.models.roles.Erole;
import com.tukiservice.models.roles.RolesService;
import com.tukiservice.models.supplier.SupplierEntity;
import com.tukiservice.models.user.UserEntity;
import com.tukiservice.repositories.user.UserEntityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    UserEntityRepository userRepository;

    @PersistenceContext
    EntityManager em;


    @Override
    public List<UserEntity> findAllUser() {
        log.info("Información de todos los Usuarios procesada...");
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity findUserById(Long id) {
        log.info("Información de Usuario procesada...");
        return userRepository.findById(id).orElse(null);

    }

    @Override
    public void createUser(UserEntityDTO userDTO) {
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

        userRepository.save(userEntity);
        log.info("Información del usuario procesada...");
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findById(id).orElse(null));
        log.info("Eliminación del usuario procesada...");
    }

    @Override
    public List<UserEntity> findUserByName(String name)  {
        String query = "FROM UserEntity WHERE name LIKE :name";
        return em.createQuery(query).setParameter("name", "%" + name + "%").getResultList();
    }

    @Override
    public boolean verifyUser(UserEntity userEntity) {
        String query = "FROM UserEntity WHERE email =:email AND password = :password";
        List<?> userList= em.createQuery(query)
                .setParameter("email",userEntity.getEmail())
                .setParameter("password",userEntity.getPassword())
                .getResultList();

        return !userList.isEmpty();

    }
}
