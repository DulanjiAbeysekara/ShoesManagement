package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerDetails(String id);

    CustomerDTO saveCustomers(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(String id,CustomerDTO customerDTO);

    void deleteCustomer(String id);


}

