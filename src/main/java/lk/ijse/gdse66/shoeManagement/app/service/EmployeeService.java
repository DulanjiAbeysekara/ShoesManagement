package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getEmployeeDetails(String id);

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    boolean deleteEmployee(String id);


//    String generateNextId();
}
