package com.example.tukiservicios.tukiservicios.repositories;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;

@Transactional
@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity,Integer> {


}