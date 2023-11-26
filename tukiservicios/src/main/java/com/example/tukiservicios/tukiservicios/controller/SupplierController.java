package com.example.tukiservicios.tukiservicios.controller;


import com.example.tukiservicios.tukiservicios.dto.SupplierDTO;
import com.example.tukiservicios.tukiservicios.models.supplier.SupplierEntity;
import com.example.tukiservicios.tukiservicios.repositories.SupplierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    SupplierDAO supplierDAO;

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

    @PostMapping
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

  /* @PutMapping("/{id}")
    public ResponseEntity<SupplierEntity> modifySupplier(@PathVariable Long id, @RequestBody SupplierEntity supplier){

    }*/

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

            }catch (IOException e) {
                throw new RuntimeException(e);
            }
            supplierDAO.createSupplier(supplier);

            flash.addFlashAttribute("success", "Uploaded successfully");
        }
        return "redirect:/";
    }
}
