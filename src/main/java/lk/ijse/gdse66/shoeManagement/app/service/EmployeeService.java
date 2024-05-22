package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getEmployeeDetails(String id);

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    boolean deleteEmployee(String id);


    @ResponseBody
    CustomDTO employeeIdGenerate();


//    String generateNextId();
}
