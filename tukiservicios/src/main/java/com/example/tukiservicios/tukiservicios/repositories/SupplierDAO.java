package com.example.tukiservicios.tukiservicios.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;

import java.util.List;



public class SupplierDAO {

    @Autowired
    SupplierRepository supplierJ;


    public List<SupplierEntity> getAllSuppliers(){
        return  supplierJ.findAll();
    }

    public SupplierEntity getSupplierById(Integer id){
        return supplierJ.getReferenceById(id);
    }

    public void createSupplier(SupplierEntity supplier){
        supplierJ.save(supplier);
    }

    public void deleteSupplier(Integer id){
        supplierJ.delete(supplierJ.findById(id).orElse(null));
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

    }
}