package com.example.tukiservicios.tukiservicios.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;

import java.util.List;


@Slf4j
public class SupplierDAO {

    @Autowired
    SupplierRepository supplierJ;


    public List<SupplierEntity> getAllSuppliers(){
        log.info("Información de todos los usuarios procesada...");
        return  supplierJ.findAll();
    }

    public SupplierEntity getSupplierById(Integer id){
        log.info("Información del usuario procesada...");
        return supplierJ.findById(id).orElse(null);
    }

    public void createSupplier(SupplierEntity supplier){
        supplierJ.save(supplier);
        log.info("Creación del usuario procesada...");
    }

    public void deleteSupplier(Integer id){
        supplierJ.delete(supplierJ.findById(id).orElse(null));
        log.info("Eliminación del usuario procesada...");
    }

    public void modifySupplier(SupplierEntity supplier){

        supplier.setSupplierName(supplier.getSupplierName());
        supplier.setFoto(supplier.getFoto());
        supplier.setEmail(supplier.getEmail());
        supplier.setPassword(supplier.getPassword());
        supplier.setResume(supplier.getResume());
        supplier.setPrice(supplier.getPrice());
        supplier.setContactNumber(supplier.getContactNumber());
        supplier.setWorkStatus(supplier.getWorkStatus());
        //supplier.setIdUser(supplier.getIdUser());
        //supplier.setIdService(supplier.getIdService());
        supplier.setProfession(supplier.getProfession());

       supplierJ.save(supplier);

        log.info("Modificación del usuario procesada...");

    }
}