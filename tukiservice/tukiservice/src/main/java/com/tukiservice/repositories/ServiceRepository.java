package com.tukiservice.repositories;
import org.springframework.data.repository.CrudRepository;
import com.tukiservice.models.supplier.ProfessionService;

public interface ServiceRepository extends CrudRepository<ProfessionService,Long> {


}
