package com.tukiservice.service.supplier;

import com.tukiservice.models.DTO.SupplierDTO;
import com.tukiservice.models.roles.Erole;
import com.tukiservice.models.roles.RolesService;
import com.tukiservice.models.supplier.SupplierEntity;
import com.tukiservice.repositories.supplier.SupplierRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierServiceImpl implements ISupplierService{

    @Autowired
    SupplierRepository supplierRepository;

    @PersistenceContext
    EntityManager em;

    @Override
    public List<SupplierEntity> findAllSuppliers() {
        return (List<SupplierEntity>) supplierRepository.findAll();
    }

    @Override
    public SupplierEntity findSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public void createSupplier(SupplierDTO supplierDTO) {
        Set<RolesService> Roles = supplierDTO.getRoles().stream()
                .map(r-> RolesService.builder()
                        .roles(Erole.valueOf(r)).build()).collect(Collectors.toSet());



        SupplierEntity supplierEntity = SupplierEntity.builder()
                .supplierName(supplierDTO.getSupplierName())
                .email(supplierDTO.getEmail())
                .contactNumber(supplierDTO.getContactNumber())
                .foto(supplierDTO.getFoto())
                .password(supplierDTO.getPassword())
                .resume(supplierDTO.getResume())
                .workStatus(supplierDTO.getWorkStatus())
                .profession(supplierDTO.getProfession())
                .roles(Roles)
                .build();

        supplierRepository.save(supplierEntity);

    }

    @Override
    public void deleteSupplierById(Long id) {
        supplierRepository.delete(supplierRepository.findById(id).orElse(null));
        log.info("Eliminación del proveedor procesada...");
    }

    @Override
    public List<SupplierEntity> findSupplierByName(String supplierName)  {
        String query = "FROM SupplierEntity WHERE supplierName LIKE :supplierName";
        return em.createQuery(query).setParameter("supplierName", "%" + supplierName + "%").getResultList();
        }

    @Override
    public List<SupplierEntity> findSupplierByProfession(String profession) {
        String query = "FROM SupplierEntity WHERE profession LIKE :profession";
        return em.createQuery(query).setParameter("profession", "%"+profession+"%").getResultList();
    }


}
