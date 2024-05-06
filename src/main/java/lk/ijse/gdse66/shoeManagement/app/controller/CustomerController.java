package lk.ijse.gdse66.shoeManagement.app.controller;


import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerDTO> getAllCustomers(){
        System.out.println("request received");
        return customerService.getAllCustomers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return customerService.saveCustomers(customerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customerDTO){
        customerDTO.setCustomerCode(id);
        customerService.updateCustomer(id,customerDTO);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomerDetails(@PathVariable("id")String id){
       return customerService.getCustomerDetails(id);
    }
}


