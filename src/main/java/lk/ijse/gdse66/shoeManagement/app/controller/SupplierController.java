package lk.ijse.gdse66.shoeManagement.app.controller;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import lk.ijse.gdse66.shoeManagement.app.service.CustomerService;
import lk.ijse.gdse66.shoeManagement.app.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    public SupplierController() {
        System.out.println("Supplier is working");
    }

    @GetMapping("/getAllSupplier")
    List<SupplierDTO>getAllSupplier(){
        System.out.println("request received");
        return supplierService.getAllSupplier();
    }

    @PostMapping("/save")
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO){
        System.out.println(supplierDTO);
        return supplierService.saveSupplier(supplierDTO);
    }

    @PatchMapping("/update")
    public SupplierDTO updateSupplier(@RequestBody SupplierDTO supplierDTO){
        System.out.println(supplierDTO);
        return supplierService.updateSupplier(supplierDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable (value = "id") String id){
        supplierService.deleteSupplier(id);
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierDTO getSupplierDetails(@PathVariable("id")String id){
        return supplierService.geSupplierDetails(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/supplierIdGenerate")
    public @ResponseBody
    CustomDTO supplierIdGenerate() {
        return supplierService.supplierIdGenerate();
    }

}
