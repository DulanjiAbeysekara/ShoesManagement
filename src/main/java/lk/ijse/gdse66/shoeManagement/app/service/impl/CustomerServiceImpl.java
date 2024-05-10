package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.CustomerRepo;
import lk.ijse.gdse66.shoeManagement.app.service.CustomerService;
import lk.ijse.gdse66.shoeManagement.app.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.shoeManagement.app.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
//@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
   private ModelMapper mapper;

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
        if (customerRepo.existsById(customerDTO.getCustomerCode())) {
            throw new DuplicateRecordException("customer ID is Already Exist");

        }
        System.out.println(customerDTO);
        return mapper.map(customerRepo.save(mapper.map(customerDTO, CustomerEntity.class)), CustomerDTO.class);
    }


    @Override
    public CustomerDTO updateCustomer( CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCustomerCode())){
            throw new NotFoundException("Can't find customer id !!");
        }

        CustomerEntity customerEntity = customerRepo.findById(customerDTO.getCustomerCode()).get();
        System.out.println("customer is "+customerEntity);

        customerDTO.setLevel(customerEntity.getLevel());
        customerDTO.setTotalPoints(customerEntity.getTotalPoints());
        customerDTO.setJoinDateLoyaltyCustomer(customerEntity.getJoinDateLoyaltyCustomer());

        return mapper.map(customerRepo.save(mapper.map(customerDTO, CustomerEntity.class)), CustomerDTO.class);

    }


    @Override
    public boolean deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new NotFoundException("Can't find customer id!!!");
        }
        customerRepo.deleteById(id);
        return true;
    }
}