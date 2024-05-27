package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSupplier();

    SupplierDTO geSupplierDetails(String id);

    SupplierDTO saveSupplier(SupplierDTO supplierDTO);

    SupplierDTO updateSupplier(SupplierDTO supplierDTO);

    boolean deleteSupplier(String id);

    List<SupplierDTO> searchSupplier(String id);

    @ResponseBody
    CustomDTO supplierIdGenerate();

}
