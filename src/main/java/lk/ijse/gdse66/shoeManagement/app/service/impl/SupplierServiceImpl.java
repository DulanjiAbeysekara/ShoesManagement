package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.EmployeeEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SupplierEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.SupplierRepo;
import lk.ijse.gdse66.shoeManagement.app.service.SupplierService;
import lk.ijse.gdse66.shoeManagement.app.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.shoeManagement.app.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepo supplierRepo;

    @Autowired
    ModelMapper mapper;

    public SupplierServiceImpl(SupplierRepo supplierRepo, ModelMapper mapper) {
        this.supplierRepo = supplierRepo;
        this.mapper = mapper;
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return supplierRepo.findAll().stream().map(supplier->mapper.map(
                supplier,SupplierDTO.class)).toList();
    }

    @Override
    public SupplierDTO geSupplierDetails(String id) {
        return null;
    }

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        if (supplierRepo.existsById(supplierDTO.getCode())){
            throw new DuplicateRecordException("Supplier ID is Already Exist");
        }
        System.out.println(supplierDTO);
        return mapper.map(supplierRepo.save(mapper.map(supplierDTO, SupplierEntity.class)), SupplierDTO.class);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        if (!supplierRepo.existsById(supplierDTO.getCode())){
            throw new NotFoundException("Can't find supplier id!!!");
        }
        SupplierEntity supplierEntity = supplierRepo.findById(supplierDTO.getCode()).get();
        System.out.println("supplier is "+supplierEntity);

        supplierDTO.setCategory(supplierEntity.getCategory());

        return mapper.map(supplierRepo.save(mapper.map(supplierDTO ,SupplierEntity.class)) ,SupplierDTO.class);
    }


    @Override
    public boolean deleteSupplier(String id) {
        if (!supplierRepo.existsById(id)){
            throw new NotFoundException("Can't find supplier id!!!");
        }
        supplierRepo.deleteById(id);
        return true;
    }

    @Override
    public List<SupplierDTO> searchSupplier(String id) {
        List<SupplierEntity> foundSupplier = supplierRepo.findByCodeStartingWith(id);

        if (foundSupplier.isEmpty()) {
            throw new NotFoundException("No suppliers found with the id: " +id);
        }
        return foundSupplier.stream()
                .map(supplier -> mapper.map(supplier, SupplierDTO.class))
                .toList();
    }

    @Override
    public CustomDTO supplierIdGenerate() {
        return new CustomDTO(supplierRepo.getLastIndex());

    }
}
