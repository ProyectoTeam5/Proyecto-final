package com.example.tukiservicios.tukiservicios.repositories;

import com.example.tukiservicios.tukiservicios.models.SupplierEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SupplierRepository extends JpaRepository<SupplierEntity,Integer> {


}
