package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
//    private Emp
    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeDTO getEmployeeDetails(String id) {
        return null;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public boolean deleteEmployee(String id) {
        return false;
    }
}
