package com.example.tukiservicios.tukiservicios.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;

import java.util.List;


@Repository
@Transactional
public class SupplierDAO {

    @PersistenceContext
    EntityManager em;


    public List<SupplierEntity> getAllSuppliers(){
        String query = "FROM SupplierEntity";
        return em.createQuery(query).getResultList();
    }

    public SupplierEntity getSupplierById(Integer id){
        return em.find(SupplierEntity.class,id);
    }

    public void createSupplier(SupplierEntity supplier){
        em.persist(supplier);
    }

    public void deleteSupplier(Integer id){
        em.remove(em.find(SupplierEntity.class,id));
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

        em.merge(supplier);

    }
}