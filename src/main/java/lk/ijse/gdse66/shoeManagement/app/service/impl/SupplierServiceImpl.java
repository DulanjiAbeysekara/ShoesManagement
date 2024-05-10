package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
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
}
