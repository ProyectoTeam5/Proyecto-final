package com.example.tukiservicios.tukiservicios.repositories;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends CrudRepository<SupplierEntity,Long> {

    //@Query("SELECT N FROM SupplierEntity N WHERE N.supplierName =: supplierName")
    //SupplierEntity findClienteByAlias(/*@Param("supplierName")*/String supplierName);

}