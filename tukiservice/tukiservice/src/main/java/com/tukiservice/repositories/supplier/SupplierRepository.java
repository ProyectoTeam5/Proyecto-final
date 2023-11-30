package com.tukiservice.repositories.supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tukiservice.models.supplier.SupplierEntity;

@Repository
public interface SupplierRepository extends CrudRepository<SupplierEntity,Long> {

    //@Query("SELECT N FROM SupplierEntity N WHERE N.supplierName =: supplierName")
    //SupplierEntity findClienteByAlias(/*@Param("supplierName")*/String supplierName);

}