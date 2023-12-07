package com.tukiservice.controller;
import com.tukiservice.service.supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tukiservice.models.DTO.SupplierDTO;
import com.tukiservice.models.supplier.SupplierEntity;
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
    ISupplierService supplierService;

    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping
    public ResponseEntity<List<SupplierEntity>> getAllSupplier(){
        List<SupplierEntity> listSupplier = supplierService.findAllSuppliers();

        if(listSupplier.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listSupplier);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierEntity> getSupplierById(@PathVariable Long id){
        SupplierEntity supplier = supplierService.findSupplierById(id);

        if(supplier == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(supplier);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSupplier(@RequestBody SupplierDTO supplier){
        supplierService.createSupplier(supplier);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierEntity> deleteSupplier(@PathVariable Long id){
        SupplierEntity supplier = supplierService.findSupplierById(id);
        if(supplier == null){
            return ResponseEntity.notFound().build();
        }else{
            supplierService.deleteSupplierById(id);
            return ResponseEntity.ok(supplier);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modifySupplier(@PathVariable("id") Long id,@RequestBody SupplierEntity supplierEntity){

        SupplierEntity newSupplier = supplierService.findSupplierById(id);

        supplierEntity.setProfession(newSupplier.getProfession());
        supplierEntity.setId(newSupplier.getId());
        supplierEntity.setRoles(newSupplier.getRoles());

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



    @GetMapping("/byname/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name){
        List<SupplierEntity> listSup= supplierService.findSupplierByName(name);
        if(listSup.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
        return ResponseEntity.ok(listSup);

        }
    }

    @GetMapping("/byprof/{profession}")
    public ResponseEntity<?> findByProffesion(@PathVariable String profession){
        List<SupplierEntity> listProf = supplierService.findSupplierByProfession(profession);
        if(listProf.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listProf);
        }
    }

    //------------------------------Images------------------------------
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
            supplierService.createSupplier(supplier);

            flash.addFlashAttribute("success", "Uploaded successfully");
        }
        return "redirect:/";
    }


    @GetMapping("/img")
    public String form(Model model){
        model.addAttribute("suppliers", new SupplierEntity());
        return "form";
    }
}
