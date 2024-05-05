package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSupplier();

    SupplierDTO getSupplierDetails(String id);

    SupplierDTO saveSupplier(SupplierDTO supplierDTO);

    void updateSupplier(String id, SupplierDTO supplierDTO);

    void deleteSupplier(String id);

}
