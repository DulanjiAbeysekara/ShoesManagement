package lk.ijse.gdse66.shoeManagement.app.controller;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import lk.ijse.gdse66.shoeManagement.app.service.CustomerService;
import lk.ijse.gdse66.shoeManagement.app.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("api/v1/supplier")
//public class SupplierController {
//
//
//    private final SupplierService supplierService;
//
//
//    public SupplierController(SupplierService supplierService1){
//        this.supplierService=supplierService1;
//
//    }
//
//
//
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    List<SupplierDTO> getAllSupplier(){
//        System.out.println("request received");
//        return supplierService.getAllSupplier();
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO){
//        return supplierService.saveSupplier(supplierDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteSupplier(@PathVariable("id") String id){
//        supplierService.deleteSupplier(id);
//    }
//
//    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateSupplier(@PathVariable("id") String id, @RequestBody SupplierDTO supplierDTO){
//        supplierDTO.setCode(id);
//        supplierService.updateSupplier(id,supplierDTO);
//    }
//
//    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public SupplierDTO getSupplierDetails(@PathVariable("id")String id){
//        return supplierService.getSupplierDetails(id);
//    }
//}

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SupplierDTO> getAllSupplier() {
        System.out.println("request received");
        return supplierService.getAllSupplier();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.saveSupplier(supplierDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSupplier(@PathVariable("id") String id) {
        supplierService.deleteSupplier(id);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSupplier(@PathVariable("id") String id, @RequestBody SupplierDTO supplierDTO) {
        supplierDTO.setCode(id);
        supplierService.updateSupplier(id, supplierDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierDTO getSupplierDetails(@PathVariable("id") String id) {
        return supplierService.getSupplierDetails(id);
    }
}
