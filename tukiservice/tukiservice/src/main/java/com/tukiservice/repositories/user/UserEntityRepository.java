package com.tukiservice.repositories.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tukiservice.models.user.UserEntity;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {

    //@Query("SELECT N FROM SupplierEntity N WHERE N.supplierName =: supplierName")
    //SupplierEntity findClienteByAlias(/*@Param("supplierName")*/String supplierName);
} 
