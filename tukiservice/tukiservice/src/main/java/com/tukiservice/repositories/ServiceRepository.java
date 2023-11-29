package com.tukiservice.repositories;
import org.springframework.data.repository.CrudRepository;
import com.tukiservice.models.supplier.Service;

public interface ServiceRepository extends CrudRepository<Service,Long> {


}
