package com.tukiservice.service.supplier;

import com.tukiservice.models.DTO.SupplierDTO;
import com.tukiservice.models.supplier.SupplierEntity;

import java.util.List;

public interface ISupplierService {


    public List<SupplierEntity> findAllSuppliers();

    public SupplierEntity findSupplierById(Long id);
    public void createSupplier(SupplierDTO supplierDTO);

    public void deleteSupplierById(Long id);

    public List<SupplierEntity> findSupplierByName(String supplierName);
    public List<SupplierEntity> findSupplierByProfession(String profession);
}
