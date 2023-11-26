package com.example.tukiservicios.tukiservicios.repositories;

import com.example.tukiservicios.tukiservicios.dto.SupplierDTO;
import com.example.tukiservicios.tukiservicios.models.supplier.ProfessionEnum;
import com.example.tukiservicios.tukiservicios.models.supplier.Service;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@org.springframework.stereotype.Service
public class SupplierDAO {

    @Autowired
    SupplierRepository supplierJ;


    public List<SupplierEntity> getAllSuppliers(){
        log.info("Información de todos los proveedores procesada...");
        return (List<SupplierEntity>) supplierJ.findAll();
    }

    public SupplierEntity getSupplierById(Long id){
        log.info("Información del proveedor procesada...");
        return supplierJ.findById(id).orElse(null);
    }

    public void createSupplier(@Valid SupplierDTO supplierDTO){
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

    public void modifySupplier(SupplierEntity supplier){

        supplier.setSupplierName(supplier.getSupplierName());
        supplier.setFoto(supplier.getFoto());
        supplier.setEmail(supplier.getEmail());
        supplier.setPassword(supplier.getPassword());
        supplier.setResume(supplier.getResume());
        supplier.setContactNumber(supplier.getContactNumber());
        //supplier.setWorkStatus(supplier.getWorkStatus());
        //supplier.setIdUser(supplier.getIdUser());
        //supplier.setIdService(supplier.getIdService());
        //supplier.setProfession(supplier.getProfession());

       supplierJ.save(supplier);

        log.info("Modificación del proveedor procesada...");

    }
}