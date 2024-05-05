package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.CustomerRepo;
import lk.ijse.gdse66.shoeManagement.app.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    CustomerRepo customerRepo;
    ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper mapper) {
        this.customerRepo = customerRepo;
        this.mapper = mapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll().stream().map(
                customer -> mapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        return null;
    }

    @Override
    public CustomerDTO saveCustomers(CustomerDTO customerDTO) {
        customerDTO.setCustomerCode(UUID.randomUUID().toString());
        return mapper.map(customerRepo.save(mapper.map(
            customerDTO, CustomerEntity.class)),CustomerDTO.class);

    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String id) {

    }
}
