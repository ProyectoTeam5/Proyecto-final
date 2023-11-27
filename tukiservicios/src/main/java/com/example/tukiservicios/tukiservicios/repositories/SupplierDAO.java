package com.example.tukiservicios.tukiservicios.repositories;

import com.example.tukiservicios.tukiservicios.dto.SupplierDTO;
import com.example.tukiservicios.tukiservicios.models.supplier.ProfessionEnum;
import com.example.tukiservicios.tukiservicios.models.supplier.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Repository
@Transactional

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
        Set<Service> Professions = supplierDTO.getProfession().stream()
                .map(r -> Service.builder()
                        .profession(ProfessionEnum.valueOf(r)).build())
                .collect(Collectors.toSet());

        SupplierEntity supplierEntity = SupplierEntity.builder()
                .supplierName(supplierDTO.getSupplierName())
                .email(supplierDTO.getEmail())
                .contactNumber(supplierDTO.getContactNumber())
                .foto(supplierDTO.getFoto())
                .password(supplierDTO.getPassword())
                .workStatus(supplierDTO.getWorkStatus())
                .resume(supplierDTO.getResume())
                .profession(Professions)
                .build();

        supplierJ.save(supplierEntity);
    }

    public void deleteSupplier(Long id){
        supplierJ.delete(supplierJ.findById(id).orElse(null));
        log.info("Eliminación del proveedor procesada...");
    }


    public SupplierEntity getSupplierByName(String supplierName){
    log.info("Información del proveedor procesada...");


    String query = "FROM SupplierEntity WHERE supplierName=:supplierName";
    return (SupplierEntity) em.createQuery(query).setParameter("supplierName",supplierName).getSingleResult();
    }





}