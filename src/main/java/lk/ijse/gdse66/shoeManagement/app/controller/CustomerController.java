package lk.ijse.gdse66.shoeManagement.app.controller;


import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cust")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private  CustomerService customerService;

    public CustomerController() {
//        this.customerService = customerService;
        System.out.println("Customer Working");
    }

    @GetMapping("/getAllCustomers")
    List<CustomerDTO> getAllCustomers(){
        System.out.println("request received");
        return customerService.getAllCustomers();
    }

    @PostMapping("/save")
   public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.saveCustomers(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(value = "id") String id){
        customerService.deleteCustomer(id);
    }


    @PatchMapping ("/update")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.updateCustomer(customerDTO);
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomerDetails(@PathVariable("id")String id){
       return customerService.getCustomerDetails(id);
    }

    @GetMapping("/search/{name}")
    public List<CustomerDTO> searchCustomer(@PathVariable(value = "name") String name){
        return customerService.searchCustomer(name);
    }

//
//    @GetMapping("/searchName/{id}")
//    public CustomerDTO searchCustomerName(@PathVariable(value = "id")String id){
//        return customerService.searchCustomerById(id);
//    }




//    @GetMapping("/{customerCode}")
//    public ResponseEntity<List<CustomerDTO>> searchCustomer(@PathVariable(value = "customer_code") String customer_code) {
//        List<CustomerDTO> customerList = customerService.searchCustomer(customer_code);
//        return ResponseEntity.ok().body(customerList);
//    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @GetMapping(path = "/cusIdGenerate")
//    public @ResponseBody
//    CustomDTO customerIdGenerate() {
//        return customerService.customerIdGenerate();
//    }
}


