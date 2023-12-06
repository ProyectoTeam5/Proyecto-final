package com.tukiservice.repositories.supplier;
import com.tukiservice.DTO.SupplierDTO;
import com.tukiservice.models.roles.Erole;
import com.tukiservice.models.roles.RolesService;
import com.tukiservice.models.supplier.SupplierEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@org.springframework.stereotype.Service
public class SupplierDAO {

    @Autowired
    SupplierRepository supplierJ;

    @PersistenceContext
    EntityManager em;


    public List<SupplierEntity> getAllSuppliers(){
        log.info("Información de todos los proveedores procesada...");
        return (List<SupplierEntity>) supplierJ.findAll();
    }

    public SupplierEntity getSupplierById(Long id){
        log.info("Información del proveedor procesada...");
        return supplierJ.findById(id).orElse(null);
    }

    public void createSupplier(SupplierDTO supplierDTO){


        Set<RolesService> Roles = supplierDTO.getRoles().stream()
                .map(r-> RolesService.builder()
                        .roles(Erole.valueOf(r)).build()).collect(Collectors.toSet());




        SupplierEntity supplierEntity = SupplierEntity.builder()
                .supplierName(supplierDTO.getSupplierName())
                .email(supplierDTO.getEmail())
                .contactNumber(supplierDTO.getContactNumber())
                .foto(supplierDTO.getFoto())
                .password(supplierDTO.getPassword())
                .resume(supplierDTO.getResume())
                .workStatus(supplierDTO.getWorkStatus())
                .profession(supplierDTO.getProfession())
                .roles(Roles)
                .build();

        supplierJ.save(supplierEntity);
    }

    public void deleteSupplier(Long id){
        supplierJ.delete(supplierJ.findById(id).orElse(null));
        log.info("Eliminación del proveedor procesada...");
    }

    public void modifySupplier(SupplierEntity supplier){

        supplier.setSupplierName(supplier.getSupplierName());
        supplier.setFoto(supplier.getFoto());
        supplier.setEmail(supplier.getEmail());
        supplier.setPassword(supplier.getPassword());
        supplier.setResume(supplier.getResume());
        supplier.setContactNumber(supplier.getContactNumber());
        //supplier.setIdUser(supplier.getIdUser());
        //supplier.setIdService(supplier.getIdService());
        //supplier.setProfession(supplier.getProfession());

       supplierJ.save(supplier);

        log.info("Modificación del proveedor procesada...");

    }

    public SupplierEntity getSupplierByName(String supplierName){
    log.info("Información del proveedor procesada...");

        String query = "FROM SupplierEntity WHERE supplierName=:supplierName";
        return (SupplierEntity) em.createQuery(query).setParameter("supplierName",supplierName).getSingleResult();
    }

   /* public List<?> findByProffesion(UserEntity user){
        String query = "FROM UserEntity WHERE profession:=".concat(user.getRoles().toString());
        //System.out.println(user);
        return null;

    }*/
}