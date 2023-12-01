package com.tukiservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tukiservice.DTO.UserEntityDTO;
import com.tukiservice.models.user.UserEntity;
import com.tukiservice.repositories.user.UserEntityDAO;
import com.tukiservice.repositories.user.UserEntityRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserEntityController {

    @Autowired
    UserEntityDAO userDAO;

    @Autowired
    UserEntityRepository userRepo;

    @PostMapping
    public ResponseEntity<?> createUsers(@RequestBody UserEntityDTO userEntityDTO){

        userDAO.createUsers(userEntityDTO);
        return ResponseEntity.ok(userEntityDTO);
    }
    
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> listusers = userDAO.getAllUsers();
        if (listusers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listusers);
        } 
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUsersById(@PathVariable Long id){
        UserEntity userentity = userDAO.getUsersById(id);
        if (userentity == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userentity);
        }
    }

    @GetMapping("byname/{name}")
    public ResponseEntity<?> getByUserName(@PathVariable("name") String name){
        UserEntity users = userDAO.getUserByName(name);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUsers(@PathVariable Long id){
        UserEntity users = userDAO.getUsersById(id);
        if (users == null) {
            return ResponseEntity.notFound().build();
        } else {
            userDAO.deleteUsers(id);
            return ResponseEntity.ok(users);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyUserEntity(@PathVariable("id") Long id, @RequestBody UserEntity userEntity ){
       
        UserEntity newUserEntity = userDAO.getUsersById(id);

        userEntity.setId(newUserEntity.getId());
        userEntity.setAddress(newUserEntity.getAddress());
        userEntity.setRoles(newUserEntity.getRoles());

        userEntity.setName(userEntity.getName());
        userEntity.setEmail(userEntity.getEmail());
        userEntity.setPassword(userEntity.getPassword());
        userEntity.setDateService(userEntity.getDateService());
        

        userRepo.save(userEntity);
        return ResponseEntity.ok(userEntity);
    
    }


}
