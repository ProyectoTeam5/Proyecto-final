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


public interface SupplierRepository extends CrudRepository<SupplierEntity,Long> {

}