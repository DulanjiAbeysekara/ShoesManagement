package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SupplierEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.CustomerRepo;
import lk.ijse.gdse66.shoeManagement.app.repository.SupplierRepo;
import lk.ijse.gdse66.shoeManagement.app.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    SupplierRepo supplierRepo;
    ModelMapper mapper;


    public SupplierServiceImpl(SupplierRepo supplierRepo, ModelMapper mapper) {
        this.supplierRepo = supplierRepo;
        this.mapper = mapper;
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return supplierRepo.findAll().stream().map(
                supplier -> mapper.map(supplier, SupplierDTO.class)).toList();
    }

    @Override
    public SupplierDTO getSupplierDetails(String id) {
        return null;
    }

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setCode(UUID.randomUUID().toString());
        return mapper.map(supplierRepo.save(mapper.map(
                supplierDTO, SupplierEntity.class)),SupplierDTO.class);
    }

    @Override
    public void updateSupplier(String id, SupplierDTO supplierDTO) {

    }

    @Override
    public void deleteSupplier(String id) {

    }
}
