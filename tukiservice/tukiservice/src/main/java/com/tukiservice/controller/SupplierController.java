package com.tukiservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tukiservice.DTO.SupplierDTO;
import com.tukiservice.models.supplier.SupplierEntity;
import com.tukiservice.repositories.supplier.SupplierDAO;
import com.tukiservice.repositories.supplier.SupplierRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    SupplierDAO supplierDAO;

    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping
    public ResponseEntity<List<SupplierEntity>> getAllSupplier(){
        List<SupplierEntity> listSupplier = supplierDAO.getAllSuppliers();

        if(listSupplier.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listSupplier);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierEntity> getSupplierById(@PathVariable Long id){
        SupplierEntity supplier = supplierDAO.getSupplierById(id);

        if(supplier == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(supplier);
        }
    }

    @PostMapping ("/auth")
    public ResponseEntity<?> createSupplier(@RequestBody SupplierDTO supplier){
        supplierDAO.createSupplier(supplier);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierEntity> deleteSupplier(@PathVariable Long id){
        SupplierEntity supplier = supplierDAO.getSupplierById(id);
        if(supplier == null){
            return ResponseEntity.notFound().build();
        }else{
            supplierDAO.deleteSupplier(id);
            return ResponseEntity.ok(supplier);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifySupplier(@PathVariable("id") Long id,@RequestBody SupplierEntity supplierEntity){

        SupplierEntity newSupplier = supplierDAO.getSupplierById(id);

        supplierEntity.setProfession(newSupplier.getProfession());
        supplierEntity.setId(newSupplier.getId());

        supplierEntity.setSupplierName(supplierEntity.getSupplierName());
        supplierEntity.setResume(supplierEntity.getResume());
        supplierEntity.setPassword(supplierEntity.getPassword());
        supplierEntity.setWorkStatus(supplierEntity.getWorkStatus());
        supplierEntity.setEmail(supplierEntity.getEmail());
        supplierEntity.setFoto(supplierEntity.getFoto());
        supplierEntity.setContactNumber(supplierEntity.getContactNumber());

        supplierRepository.save(supplierEntity);
        return ResponseEntity.ok(supplierEntity);

    }




    @GetMapping("/supplier/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name){
        SupplierEntity supp= supplierDAO.getSupplierByName(name);
        return ResponseEntity.ok(supp);
    }


    @PostMapping("/")
    public String saveIMG(@RequestParam(name="file", required = false) MultipartFile photo, SupplierDTO supplier,
                          RedirectAttributes flash){
        if(!photo.isEmpty()){
            String route = "src//main//resources//static/img";

            try {
                byte[] bytes = photo.getBytes();
                Path absoluteRoute = Paths.get(route + "//" + photo.getOriginalFilename());
                Files.write(absoluteRoute,bytes);
                supplier.setFoto(photo.getOriginalFilename());
                supplier.setFoto(Objects.requireNonNull(photo.getOriginalFilename()));

            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            supplierDAO.createSupplier(supplier);

            flash.addFlashAttribute("success", "Uploaded successfully");
        }
        return "redirect:/";
    }



}
